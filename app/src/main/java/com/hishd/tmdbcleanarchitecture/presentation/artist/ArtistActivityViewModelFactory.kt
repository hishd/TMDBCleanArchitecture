package com.hishd.tmdbcleanarchitecture.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hishd.tmdbcleanarchitecture.domain.usecase.GetArtistsUseCase
import com.hishd.tmdbcleanarchitecture.domain.usecase.UpdateArtistsUseCase

class ArtistActivityViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistActivityViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}