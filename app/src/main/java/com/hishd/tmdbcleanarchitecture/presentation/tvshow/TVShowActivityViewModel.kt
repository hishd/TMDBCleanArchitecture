package com.hishd.tmdbcleanarchitecture.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hishd.tmdbcleanarchitecture.domain.usecase.GetTVShowsUseCase
import com.hishd.tmdbcleanarchitecture.domain.usecase.UpdateTVShowsUseCase

class TVShowActivityViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
): ViewModel() {

    fun getTVShows() = liveData {
        emit(getTVShowsUseCase.execute())
    }

    fun updateTVShows() = liveData {
        emit(updateTVShowsUseCase.execute())
    }
}