package com.hishd.tmdbcleanarchitecture.data.repository.tvshow

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow

class TVShowCachedDataSourceImpl: TVShowCachedDataSource {

    private val tvShowList = ArrayList<TVShow>()

    override suspend fun getTVShowsFromCache(): List<TVShow> = tvShowList

    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
}