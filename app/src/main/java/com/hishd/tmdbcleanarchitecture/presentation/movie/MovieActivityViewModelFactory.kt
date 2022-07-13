package com.hishd.tmdbcleanarchitecture.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hishd.tmdbcleanarchitecture.domain.usecase.GetMoviesUseCase
import com.hishd.tmdbcleanarchitecture.domain.usecase.UpdateMoviesUseCase

class MovieActivityViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieActivityViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}