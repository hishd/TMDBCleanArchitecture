package com.hishd.tmdbcleanarchitecture.data.repository.tvshow

import com.hishd.tmdbcleanarchitecture.data.api.TMDBService
import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShowList
import retrofit2.Response

class TVShowRemoteDataSourceImpl(private val service: TMDBService, private val apiKey: String): TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> = service.getPopularTVShows(apiKey)
}