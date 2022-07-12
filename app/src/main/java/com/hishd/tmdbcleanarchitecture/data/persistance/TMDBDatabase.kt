package com.hishd.tmdbcleanarchitecture.data.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hishd.tmdbcleanarchitecture.data.model.artist.Artist
import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie
import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow
import com.hishd.tmdbcleanarchitecture.data.persistance.dao.ArtistDao
import com.hishd.tmdbcleanarchitecture.data.persistance.dao.MovieDao
import com.hishd.tmdbcleanarchitecture.data.persistance.dao.TVShowDao

@Database(entities = [Movie::class, Artist::class, TVShow::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao() : MovieDao
    abstract fun tvShowDao() : TVShowDao
    abstract fun artistDao() : ArtistDao
}