package com.example.superhero.features.superheroes.domain

import com.example.superhero.features.superheroes.domain.atributes.SuperHero

interface SuperHeroRepository {

    suspend fun getSuperHeroes(): List<SuperHero>
    suspend fun getSuperHero(superheroId: String): SuperHero?
}