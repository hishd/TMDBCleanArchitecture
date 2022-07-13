package com.hishd.tmdbcleanarchitecture.data.repository.movie

import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie
import com.hishd.tmdbcleanarchitecture.data.model.movie.MovieList

class MovieCachedDataSourceImpl: MovieCachedDataSource {
    private val movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }
}