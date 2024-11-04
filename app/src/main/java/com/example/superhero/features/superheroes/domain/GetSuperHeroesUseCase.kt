package com.example.superhero.features.superheroes.domain

import com.example.superhero.features.superheroes.domain.atributes.SuperHero
import org.koin.core.annotation.Single


@Single
class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {
    suspend operator fun invoke(): List<SuperHero> {
    return superHeroRepository.getSuperHeroes()
    }
}