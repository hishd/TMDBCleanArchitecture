package com.hishd.tmdbcleanarchitecture.domain.usecase

import com.hishd.tmdbcleanarchitecture.data.model.tvshow.TVShow
import com.hishd.tmdbcleanarchitecture.domain.repository.TVShowRepository

class UpdateTVShowsUseCase(private val tvShowRepository: TVShowRepository) : BaseUseCase<TVShow> {
    override suspend fun execute() : List<TVShow>? = tvShowRepository.updateTVShows()
}