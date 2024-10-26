package com.example.superhero.features.superheroes.domain

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    suspend operator fun invoke(superheroId: String): SuperHero? {
        return superHeroRepository.getSuperHero(superheroId)
    }
}