package com.hishd.tmdbcleanarchitecture.data.repository.artist

import com.hishd.tmdbcleanarchitecture.data.model.artist.Artist

class ArtistCachedDataSourceImpl: ArtistCachedDataSource {

    private val artistsList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> = artistsList

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList.addAll(artists)
    }
}