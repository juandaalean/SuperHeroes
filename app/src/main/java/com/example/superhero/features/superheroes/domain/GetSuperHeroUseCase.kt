package com.example.superhero.features.superheroes.domain

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(superheroId: String): SuperHero? {
        return superHeroRepository.getSuperHero(superheroId)
    }
}