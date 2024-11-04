package com.example.superhero.features.superheroes.presentation

import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.superhero.app.extensions.loadUrl
import com.example.superhero.databinding.ViewSuperheroItemBinding
import com.example.superhero.features.superheroes.domain.atributes.SuperHero
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SuperHeroViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    private lateinit var binding: ViewSuperheroItemBinding

    fun bind(model: SuperHero){
        binding = ViewSuperheroItemBinding.bind(view)
        binding.apply {
            image.loadUrl(model.images)
            name.text = model.name
            superheroViewLayout.setOnClickListener {
                navigateToDetails(model.id)
            }
        }
    }

    private fun navigateToDetails(superHeroId: String) {
        findNavController(view).navigate(
            SuperHeroesFragmentDirections.actionSuperheroToSuperheroDetail(superHeroId = superHeroId)
        )
    }
}