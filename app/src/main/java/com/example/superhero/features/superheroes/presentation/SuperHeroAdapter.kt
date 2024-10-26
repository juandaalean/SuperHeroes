package com.example.superhero.features.superheroes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.superhero.R
import com.example.superhero.features.superheroes.domain.atributes.SuperHero

class SuperHeroAdapter() : ListAdapter<SuperHero, SuperHeroViewHolder>(SuperHeroDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_superhero_item, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}