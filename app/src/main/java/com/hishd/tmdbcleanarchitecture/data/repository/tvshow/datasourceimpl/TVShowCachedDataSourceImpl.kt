package com.hishd.tmdbcleanarchitecture.data.repository.tvshow.datasourceimpl

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow
import com.hishd.tmdbcleanarchitecture.data.repository.tvshow.datasource.TVShowCachedDataSource

class TVShowCachedDataSourceImpl: TVShowCachedDataSource {

    private val tvShowList = ArrayList<TVShow>()

    override suspend fun getTVShowsFromCache(): List<TVShow> = tvShowList

    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
}