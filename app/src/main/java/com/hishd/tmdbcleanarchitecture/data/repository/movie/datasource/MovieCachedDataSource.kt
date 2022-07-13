package com.hishd.tmdbcleanarchitecture.data.repository.movie.datasource

import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie

interface MovieCachedDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}