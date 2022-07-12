package com.hishd.tmdbcleanarchitecture.domain.usecase

import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie
import com.hishd.tmdbcleanarchitecture.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) : BaseUseCase<Movie> {
    override suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}