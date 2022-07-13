package com.hishd.tmdbcleanarchitecture.data.repository.artist

import com.hishd.tmdbcleanarchitecture.data.api.TMDBService
import com.hishd.tmdbcleanarchitecture.data.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val service: TMDBService, private val apiKey: String): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = service.getPopularArtists(apiKey)
}