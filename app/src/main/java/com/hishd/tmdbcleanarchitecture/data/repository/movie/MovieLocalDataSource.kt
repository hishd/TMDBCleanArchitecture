package com.hishd.tmdbcleanarchitecture.data.repository.movie

import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}