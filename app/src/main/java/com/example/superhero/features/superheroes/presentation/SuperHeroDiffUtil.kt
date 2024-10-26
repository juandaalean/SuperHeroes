package com.example.superhero.features.superheroes.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.superhero.features.superheroes.domain.atributes.SuperHero


class SuperHeroDiffUtil : DiffUtil.ItemCallback<SuperHero>() {
    override fun areItemsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SuperHero, newItem: SuperHero): Boolean {
        return oldItem == newItem
    }
}