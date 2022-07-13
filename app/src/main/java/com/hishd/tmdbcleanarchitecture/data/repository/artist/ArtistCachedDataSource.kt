package com.hishd.tmdbcleanarchitecture.data.repository.artist

import com.hishd.tmdbcleanarchitecture.data.model.artist.Artist

interface ArtistCachedDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}