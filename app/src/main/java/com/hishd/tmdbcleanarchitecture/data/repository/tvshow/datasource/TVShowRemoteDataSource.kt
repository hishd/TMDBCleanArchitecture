package com.hishd.tmdbcleanarchitecture.data.repository.tvshow.datasource

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowList>
}