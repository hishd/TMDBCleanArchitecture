package com.hishd.tmdbcleanarchitecture.data.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow
import kotlinx.coroutines.flow.Flow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTVShows(shows: List<TVShow>)

    @Query("DELETE FROM tv_shows")
    suspend fun deleteAllTVShows()

    @Query("SELECT * FROM tv_shows")
    fun getTVShows() : List<TVShow>
}