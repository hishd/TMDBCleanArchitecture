package com.hishd.tmdbcleanarchitecture.data.repository.tvshow

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun saveTVShowsToDB(tvSHows: List<TVShow>)
    suspend fun clearAll()
}