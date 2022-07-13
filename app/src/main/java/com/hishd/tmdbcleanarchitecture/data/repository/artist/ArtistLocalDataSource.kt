package com.hishd.tmdbcleanarchitecture.data.repository.artist

import com.hishd.tmdbcleanarchitecture.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}