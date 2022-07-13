package com.hishd.tmdbcleanarchitecture.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hishd.tmdbcleanarchitecture.domain.usecase.GetArtistsUseCase
import com.hishd.tmdbcleanarchitecture.domain.usecase.UpdateArtistsUseCase

class ArtistActivityViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {
    fun getArtists() = liveData {
        emit(getArtistsUseCase.execute())
    }

    fun updateArtistList() = liveData {
        emit(updateArtistsUseCase.execute())
    }
}