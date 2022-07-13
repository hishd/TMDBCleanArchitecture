package com.hishd.tmdbcleanarchitecture.data.repository.tvshow

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow
import com.hishd.tmdbcleanarchitecture.domain.repository.TVShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCachedDataSource: TVShowCachedDataSource
): TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? = getTVShowsFromCache()

    override suspend fun updateTVShows(): List<TVShow>? {
        val tvShowsList = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowsToDB(tvShowsList)
        tvShowCachedDataSource.saveTVShowsToCache(tvShowsList)
        return tvShowsList
    }

    private suspend fun getTVShowsFromAPI() : List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            val response = tvShowRemoteDataSource.getTVShows().body()
            response?.let {
                tvShowList = it.tvShows
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return tvShowList
    }

    private suspend fun getTVShowsFromDB() : List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowLocalDataSource.getTVShowsFromDB()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        if(tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTVShowsFromAPI()
            tvShowLocalDataSource.saveTVShowsToDB(tvShowList)
        }

        return tvShowList
    }

    private suspend fun getTVShowsFromCache() : List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowCachedDataSource.getTVShowsFromCache()
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        if(tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTVShowsFromDB()
            tvShowCachedDataSource.saveTVShowsToCache(tvShowList)
        }

        return tvShowList
    }
}