package com.hishd.tmdbcleanarchitecture.domain.usecase

import com.hishd.tmdbcleanarchitecture.data.model.artist.Artist
import com.hishd.tmdbcleanarchitecture.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) : BaseUseCase<Artist> {
    override suspend fun execute() : List<Artist>? = artistRepository.updateArtists()
}