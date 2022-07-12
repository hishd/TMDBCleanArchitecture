package com.hishd.tmdbcleanarchitecture.domain.repository

import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}