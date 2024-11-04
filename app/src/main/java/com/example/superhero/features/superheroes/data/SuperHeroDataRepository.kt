package com.example.superhero.features.superheroes.data

import com.example.superhero.features.superheroes.data.local.SuperHeroXmlLocalDataSource
import com.example.superhero.features.superheroes.data.remote.SuperHeroApiRemoteDataSource
import com.example.superhero.features.superheroes.domain.atributes.SuperHero
import com.example.superhero.features.superheroes.domain.SuperHeroRepository
import org.koin.core.annotation.Single

@Single
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