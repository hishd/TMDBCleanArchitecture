package com.hishd.tmdbcleanarchitecture.domain.usecase

import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie
import com.hishd.tmdbcleanarchitecture.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) : BaseUseCase<Movie> {
    override suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}