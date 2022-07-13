package com.hishd.tmdbcleanarchitecture.data.repository.tvshow

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow
import com.hishd.tmdbcleanarchitecture.data.persistance.dao.TVShowDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val dao: TVShowDao): TVShowLocalDataSource {
    override suspend fun getTVShowsFromDB(): List<TVShow> = dao.getTVShows()

    override suspend fun saveTVShowsToDB(tvSHows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.addTVShows(tvSHows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllTVShows()
        }
    }
}