package com.hishd.tmdbcleanarchitecture.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hishd.tmdbcleanarchitecture.domain.usecase.GetTVShowsUseCase
import com.hishd.tmdbcleanarchitecture.domain.usecase.UpdateTVShowsUseCase

class TVShowActivityViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowActivityViewModel(getTVShowsUseCase, updateTVShowsUseCase) as T
    }
}