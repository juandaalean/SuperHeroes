package com.example.superhero.features.superheroes.data.remote

import com.example.superhero.features.superheroes.domain.SuperHero
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {


    @GET("all.json")
    suspend fun requestSuperHeroes(): Response<List<SuperHero>>

    @GET("id/{superHeroId}.json")
    suspend fun requestSuperHero(@Path("superHeroId") superHeroId: String): Response<SuperHero>
}