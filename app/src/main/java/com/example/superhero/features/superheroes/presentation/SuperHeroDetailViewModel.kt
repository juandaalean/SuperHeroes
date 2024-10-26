package com.example.superhero.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superhero.app.domain.ErrorApp
import com.example.superhero.features.superheroes.domain.GetSuperHeroUseCase
import com.example.superhero.features.superheroes.domain.atributes.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperHeroDetailViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun viewCreated(superHeroId: String) {
        _uiState.value = (UiState(isLoading = true))

        viewModelScope.launch(Dispatchers.IO) {
            val superHero = getSuperHeroUseCase.invoke(superHeroId)
            _uiState.postValue(UiState(superHero = superHero))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superHero: SuperHero? = null
    )
}