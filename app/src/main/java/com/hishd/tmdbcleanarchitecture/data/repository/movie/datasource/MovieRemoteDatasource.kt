package com.hishd.tmdbcleanarchitecture.data.repository.movie.datasource

import com.hishd.tmdbcleanarchitecture.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}