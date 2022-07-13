package com.hishd.tmdbcleanarchitecture.data.repository.artist.datasource

import com.hishd.tmdbcleanarchitecture.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists() : Response<ArtistList>
}