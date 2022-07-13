package com.hishd.tmdbcleanarchitecture.data.persistance.dao

import androidx.room.*
import com.hishd.tmdbcleanarchitecture.data.model.movie.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movies")
    fun getMovies() : List<Movie>
}