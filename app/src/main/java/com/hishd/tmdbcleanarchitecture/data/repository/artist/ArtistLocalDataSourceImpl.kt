package com.hishd.tmdbcleanarchitecture.data.repository.artist

import com.hishd.tmdbcleanarchitecture.data.model.artist.Artist
import com.hishd.tmdbcleanarchitecture.data.persistance.dao.ArtistDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val dao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist>  = dao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.addArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteArtists()
        }
    }
}