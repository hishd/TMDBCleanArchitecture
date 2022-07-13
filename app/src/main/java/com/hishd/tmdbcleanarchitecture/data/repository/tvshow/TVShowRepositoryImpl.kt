package com.hishd.tmdbcleanarchitecture.data.repository.tvshow

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow
import com.hishd.tmdbcleanarchitecture.domain.repository.TVShowRepository

class TVShowRepositoryImpl: TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        TODO("Not yet implemented")
    }
}