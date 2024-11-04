package com.example.superhero.features.superheroes.data.remote

import com.example.superhero.features.superheroes.domain.atributes.SuperHero


fun SuperHeroApiModel.toModel(): SuperHero {
    return SuperHero(
        this.id,
        this.name,
        this.slug,
        this.powerStats,
        this.appearance,
        this.biography,
        this.work,
        this.connections,
        this.images.lg
    )
}