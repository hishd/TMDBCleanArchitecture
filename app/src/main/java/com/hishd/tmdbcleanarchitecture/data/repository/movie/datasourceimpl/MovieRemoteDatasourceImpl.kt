package com.hishd.tmdbcleanarchitecture.data.repository.movie.datasourceimpl

import com.hishd.tmdbcleanarchitecture.data.api.TMDBService
import com.hishd.tmdbcleanarchitecture.data.model.movie.MovieList
import com.hishd.tmdbcleanarchitecture.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val service: TMDBService, private val apiKey: String):
    MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = service.getPopularMovies(apiKey)
}