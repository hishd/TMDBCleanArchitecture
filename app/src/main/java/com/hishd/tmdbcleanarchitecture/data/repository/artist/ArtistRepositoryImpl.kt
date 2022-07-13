package com.hishd.tmdbcleanarchitecture.data.repository.artist

import com.hishd.tmdbcleanarchitecture.data.model.artist.Artist
import com.hishd.tmdbcleanarchitecture.data.repository.artist.datasource.ArtistCachedDataSource
import com.hishd.tmdbcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.hishd.tmdbcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.hishd.tmdbcleanarchitecture.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCachedDataSource: ArtistCachedDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val artistList = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(artistList)
        artistCachedDataSource.saveArtistsToCache(artistList)
        return artistList
    }

    private suspend fun getArtistsFromAPI() : List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists().body()
            if(response != null) {
                artistList = response.artists
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return artistList
    }

    private suspend fun getArtistsFromDatabase() : List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        if(artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    private suspend fun getArtistsFromCache() : List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCachedDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        if(artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDatabase()
            artistCachedDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}