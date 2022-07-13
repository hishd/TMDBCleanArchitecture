package com.hishd.tmdbcleanarchitecture.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie
import com.hishd.tmdbcleanarchitecture.domain.usecase.GetMoviesUseCase
import com.hishd.tmdbcleanarchitecture.domain.usecase.UpdateMoviesUseCase

class MovieActivityViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        emit(getMoviesUseCase.execute())
    }

    fun updateMovieList() = liveData {
        emit(updateMoviesUseCase.execute())
    }

}