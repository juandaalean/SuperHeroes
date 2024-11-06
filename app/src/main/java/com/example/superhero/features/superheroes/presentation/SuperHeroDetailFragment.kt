package com.example.superhero.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.superhero.app.extensions.loadUrl
import com.example.superhero.databinding.FragmentSuperheroDetailBinding
import com.example.superhero.features.superheroes.domain.atributes.SuperHero

class SuperHeroDetailFragment : Fragment() {

    private lateinit var factory: SuperHeroesFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

    private val superHeroArgs : SuperHeroDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = SuperHeroesFactory(requireContext())
        viewModel = factory.buildSuperHeroDetailViewModel()
        getSuperHeroId()?.let {
            viewModel.viewCreated(it)
        }
        setupObserver()
        superHeroArgs.superHeroId
    }

    private fun setupObserver() {
        val superHeroObserver = Observer<SuperHeroDetailViewModel.UiState> { uiState ->
            uiState.superHero?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargado")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, superHeroObserver)
    }

    private fun getSuperHeroId(): String {
        return superHeroArgs.superHeroId
    }

    private fun bindData(superhero: SuperHero) {
        binding.apply {
            superHeroImage.loadUrl(superhero.images.lg)
            superHeroName.text = superhero.name
            superHeroId.text = superhero.id
            superHeroBase.text = superhero.work.base
            superHeroOccupation.text = superhero.work.occupation
            superHeroFullName.text = superhero.biography.fullName
            superHeroAlterEgos.text = superhero.biography.alterEgos
            aliases.text = superhero.biography.aliases.toString()
            fisrtAppearance.text = superhero.biography.firstAppearance
        }
    }
}