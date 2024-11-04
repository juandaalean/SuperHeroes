package com.example.superhero.features.superheroes.data.remote

import com.example.superhero.features.superheroes.domain.atributes.Appearance
import com.example.superhero.features.superheroes.domain.atributes.Biography
import com.example.superhero.features.superheroes.domain.atributes.Connections
import com.example.superhero.features.superheroes.domain.atributes.Images
import com.example.superhero.features.superheroes.domain.atributes.PowerStats
import com.example.superhero.features.superheroes.domain.atributes.Work
import com.google.gson.annotations.SerializedName

data class SuperHeroApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("powerstats") val powerStats: PowerStats,
    @SerializedName("appearance") val appearance: Appearance,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("work") val work: Work,
    @SerializedName("connections") val connections: Connections,
    @SerializedName("images") val images: SuperHeroImageApiModel
)

data class SuperHeroImageApiModel(val lg: String)

