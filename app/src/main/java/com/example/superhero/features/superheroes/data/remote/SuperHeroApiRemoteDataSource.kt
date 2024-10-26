package com.example.superhero.features.superheroes.data.remote

import com.example.superhero.features.superheroes.domain.atributes.Appearance
import com.example.superhero.features.superheroes.domain.atributes.Biography
import com.example.superhero.features.superheroes.domain.atributes.Connections
import com.example.superhero.features.superheroes.domain.atributes.Images
import com.example.superhero.features.superheroes.domain.atributes.PowerStats
import com.example.superhero.features.superheroes.domain.atributes.SuperHero
import com.example.superhero.features.superheroes.domain.atributes.Work

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
            return SuperHero(
                id = "Error",
                name = "Error",
                slug = "Error",
                powerStats = PowerStats(
                    intelligence = 0,
                    strength = 0,
                    speed = 0,
                    durability = 0,
                    power = 0,
                    combat = 0
                ),
                appearance = Appearance(
                    gender = "error",
                    race = "error",
                    height = listOf("error", "error"),
                    weight = listOf("error", "error"),
                    eyeColor = "error",
                    hairColor = "error"
                ),
                biography = Biography(
                    fullName = "error",
                    alterEgos = "error",
                    aliases = listOf("error"),
                    placeOfBirth = "error",
                    firstAppearance = "error",
                    publisher = "error",
                    alignment = "error"
                ),
                work = Work(
                    occupation = "error",
                    base = "-"
                ),
                connections = Connections(
                    groupAffiliation = "error",
                    relatives = "error"
                ),
                images = Images(
                    "error",
                    "error",
                    "error",
                    "error"
                )
            )
        }
    }
}