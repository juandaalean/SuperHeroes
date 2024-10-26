package com.example.superhero.features.superheroes.data.remote

import com.example.superhero.features.superheroes.domain.SuperHero

class SuperHeroApiRemoteDataSource(private val superHeroService: SuperHeroService) {

    suspend fun getSuperHeroes(): List<SuperHero> {
        val response = superHeroService.requestSuperHeroes()
        if (response.isSuccessful) {
            return response.body()!!
        } else{
            return emptyList()
        }
    }

    suspend fun getSuperHero(superHeroId: String): SuperHero {
        val response = superHeroService.requestSuperHero(superHeroId)
        if (response.isSuccessful) {
            return response.body()!!
        } else{
            return SuperHero("error", "error", "error")
        }
    }
}