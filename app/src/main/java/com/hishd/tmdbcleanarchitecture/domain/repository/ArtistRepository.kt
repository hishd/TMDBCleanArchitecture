package com.hishd.tmdbcleanarchitecture.domain.repository

import com.hishd.tmdbcleanarchitecture.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?
}