package com.hishd.tmdbcleanarchitecture.data.api

import com.hishd.tmdbcleanarchitecture.data.model.artist.ArtistList
import com.hishd.tmdbcleanarchitecture.data.model.movie.MovieList
import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String) : Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String) : Response<ArtistList>
}