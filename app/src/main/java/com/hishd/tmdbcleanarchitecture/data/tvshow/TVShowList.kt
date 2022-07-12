package com.hishd.tmdbcleanarchitecture.data.tvshow


import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val tvShows: List<TVShow>,
)