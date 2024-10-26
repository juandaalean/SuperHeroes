package com.example.superhero.features.superheroes.domain

interface SuperHeroRepository {

    fun getSuperHeroes(): List<SuperHero>
    fun getSuperHero(superheroId: String): SuperHero?
}