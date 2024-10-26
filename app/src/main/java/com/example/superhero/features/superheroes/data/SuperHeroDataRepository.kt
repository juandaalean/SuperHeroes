package com.example.superhero.features.superheroes.data

import android.content.Context
import com.example.superhero.features.superheroes.data.local.SuperHeroXmlLocalDataSource
import com.example.superhero.features.superheroes.data.remote.SuperHeroApiRemoteDataSource
import com.example.superhero.features.superheroes.domain.SuperHero
import com.example.superhero.features.superheroes.domain.SuperHeroRepository

class SuperHeroDataRepository(
    private val local: SuperHeroXmlLocalDataSource,
    private val remote: SuperHeroApiRemoteDataSource
): SuperHeroRepository {

    override suspend fun getSuperHeroes(): List<SuperHero> {
        val superHeroesFromLocal = local.findAll()
        if (superHeroesFromLocal.isEmpty()){
            val superHeroFormRemote = remote.getSuperHeroes()
            local.saveAll(superHeroFormRemote)
            return superHeroFormRemote
        } else{
            return superHeroesFromLocal
        }
    }

    override suspend fun getSuperHero(superHeroId: String): SuperHero? {
        val localSuperHero = local.findById(superHeroId)
        if (localSuperHero != null){
            remote.getSuperHero(superHeroId)?.let {
                local.save(it)
                return it
            }
        }
        return null
    }
}