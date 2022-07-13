package com.hishd.tmdbcleanarchitecture.data.repository.movie

import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie
import com.hishd.tmdbcleanarchitecture.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieCachedDataSource: MovieCachedDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val movies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(movies)
        movieCachedDataSource.saveMoviesToCache(movies)
        return movies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movies: List<Movie>
        try {
            val response = movieRemoteDatasource.getMovies().body()
            if (response != null) {
                movies = response.movies
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        return movies
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movies: List<Movie>
        try {
            movies = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        if(movies.isNotEmpty()) {
            return movies
        } else {
            movies = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movies)
        }

        return movies
    }

    private suspend fun getMoviesFromCache() : List<Movie> {
        lateinit var movies: List<Movie>
        try {
            movies = movieCachedDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        if(movies.isNotEmpty()) {
            return movies
        } else {
            movies = getMoviesFromDB()
            movieCachedDataSource.saveMoviesToCache(movies)
        }

        return movies
    }
}