package com.example.superhero.features.superheroes.presentation

import android.content.Context
import com.example.superhero.app.data.api.ApiClient
import com.example.superhero.features.superheroes.data.SuperHeroDataRepository
import com.example.superhero.features.superheroes.data.local.SuperHeroXmlLocalDataSource
import com.example.superhero.features.superheroes.data.remote.SuperHeroApiRemoteDataSource
import com.example.superhero.features.superheroes.domain.GetSuperHeroUseCase
import com.example.superhero.features.superheroes.domain.GetSuperHeroesUseCase

class SuperHeroesFactory(private val context: Context) {

    private val superHeroLocal = SuperHeroXmlLocalDataSource(context)
    private val superHeroDataRepository = SuperHeroDataRepository(superHeroLocal, getSuperHeroApiRemoteDataSource())

    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)

    fun buildViewModel(): SuperHeroesViewModel {
        return SuperHeroesViewModel(getSuperHeroesUseCase)
    }

    fun buildSuperHeroDetailViewModel(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(getSuperHeroUseCase)
    }

    private fun getSuperHeroApiRemoteDataSource(): SuperHeroApiRemoteDataSource{
        val superHeroService = ApiClient.provideSuperHeroService()
        return SuperHeroApiRemoteDataSource(superHeroService)
    }
}