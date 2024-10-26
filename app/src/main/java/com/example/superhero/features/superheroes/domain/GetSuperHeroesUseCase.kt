package com.example.superhero.features.superheroes.domain

class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {
    operator fun invoke(): List<SuperHero> {
    return superHeroRepository.getSuperHeroes()
    }
}