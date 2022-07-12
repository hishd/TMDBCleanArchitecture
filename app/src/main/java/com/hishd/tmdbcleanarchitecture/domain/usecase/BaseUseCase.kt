package com.hishd.tmdbcleanarchitecture.domain.usecase

interface BaseUseCase<T> {
    suspend fun execute(): List<T>?
}