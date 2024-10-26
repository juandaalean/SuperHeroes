package com.example.superhero.features.superheroes.domain

class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {
    suspend operator fun invoke(): List<SuperHero> {
    return superHeroRepository.getSuperHeroes()
    }
}