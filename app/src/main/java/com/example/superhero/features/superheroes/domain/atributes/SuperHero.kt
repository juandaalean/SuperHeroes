package com.example.superhero.features.superheroes.domain.atributes

data class SuperHero(
    val id: String,
    val name: String,
    val slug: String,
    val powerStats: PowerStats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections: Connections,
    val images: String
)
