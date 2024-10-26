package com.example.superhero.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superhero.app.domain.ErrorApp
import com.example.superhero.databinding.FragmentSuperheroesBinding

class SuperHeroesFragment : Fragment() {

    private lateinit var factory: SuperHeroesFactory
    private lateinit var viewModel: SuperHeroesViewModel

    private var _binding: FragmentSuperheroesBinding? = null
    private val binding get() = _binding!!

    private val superheroAdapter = SuperHeroAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroesBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.apply {
            recyclerViewSuperheroes.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            recyclerViewSuperheroes.adapter = superheroAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = SuperHeroesFactory(requireContext())
        viewModel = factory.buildViewModel()
        viewModel.viewCreated()
        setupObserver()
    }

    private fun setupObserver() {
        val movieObserver = Observer<SuperHeroesViewModel.UiState> { uiState ->
            uiState.superHeroes?.let {
                superheroAdapter.submitList(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            } ?:    run {
                //ocultar error
            }
            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargado")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}