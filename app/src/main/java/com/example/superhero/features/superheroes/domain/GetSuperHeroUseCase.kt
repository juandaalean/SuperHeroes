package com.example.superhero.features.superheroes.domain

import com.example.superhero.features.superheroes.domain.atributes.SuperHero

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    suspend operator fun invoke(superheroId: String): SuperHero? {
        return superHeroRepository.getSuperHero(superheroId)
    }
}