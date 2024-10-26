package com.example.superhero.features.superheroes.domain

interface SuperHeroRepository {

    suspend fun getSuperHeroes(): List<SuperHero>
    suspend fun getSuperHero(superheroId: String): SuperHero?
}