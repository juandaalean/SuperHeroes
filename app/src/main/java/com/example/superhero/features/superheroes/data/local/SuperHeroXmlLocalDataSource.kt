package com.example.superhero.features.superheroes.data.local

import android.content.Context
import com.example.superhero.R
import com.example.superhero.features.superheroes.domain.SuperHero
import com.google.gson.Gson

class SuperHeroXmlLocalDataSource(private val context: Context) {

    private val sharedPref =context.getSharedPreferences(
        context.getString(R.string.app_file_name), Context.MODE_PRIVATE
    )

    private val editor = sharedPref.edit()
    private val gson = Gson()


    fun save(superHero: SuperHero) {
        editor.putString(superHero.id, gson.toJson(superHero))
        editor.apply()
    }

    fun saveAll(superHeroes: List<SuperHero>) {
        superHeroes.forEach { superHero ->
            editor.putString(superHero.id, gson.toJson(superHero))
        }
        editor.apply()
    }

    fun findAll(): List<SuperHero> {
        val superHeroes = ArrayList<SuperHero>()
        val mapSuperHeroes = sharedPref.all
        mapSuperHeroes.forEach{ jsonSuperHeroes ->
            val superHero = gson.fromJson(jsonSuperHeroes as String, SuperHero::class.java)
            superHeroes.add(superHero)
        }
        return superHeroes
    }

    fun findById(superheroId: String): SuperHero? {
        return sharedPref.getString(superheroId, null)?.let { superHero ->
            gson.fromJson(superHero, SuperHero::class.java)
        }
    }
}