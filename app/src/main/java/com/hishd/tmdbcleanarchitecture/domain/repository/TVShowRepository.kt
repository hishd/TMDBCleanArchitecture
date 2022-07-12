package com.hishd.tmdbcleanarchitecture.domain.repository

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow

interface TVShowRepository {
    suspend fun getTVShows() : List<TVShow>?
    suspend fun updateTVShows() : List<TVShow>?
}