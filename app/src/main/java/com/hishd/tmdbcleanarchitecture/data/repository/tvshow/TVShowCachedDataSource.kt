package com.hishd.tmdbcleanarchitecture.data.repository.tvshow

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow

interface TVShowCachedDataSource {
    suspend fun getTVShowsFromCache() : List<TVShow>
    suspend fun saveTVShowsToCache(tvShows: List<TVShow>)
}