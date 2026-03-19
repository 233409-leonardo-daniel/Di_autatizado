
package com.alilopez.kt_demohilt.features.recipebook.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alilopez.kt_demohilt.features.recipebook.domain.usecases.GetMealsUseCase
import com.alilopez.kt_demohilt.features.recipebook.domain.usecases.SearchMealByNameUseCase
import com.alilopez.kt_demohilt.features.recipebook.presentation.screens.MealsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val searchMealByNameUseCase: SearchMealByNameUseCase,
    private val getMealsUseCase: GetMealsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MealsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getMeals()
    }

    private fun getMeals() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            try {
                val result = getMealsUseCase()
                _uiState.update { currentState ->
                    currentState.copy(isLoading = false, meals = result)
                }
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(isLoading = false, error = e.message)
                }
            }
        }
    }

    fun searchMealByName(mealName: String) {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            try {
                val result = searchMealByNameUseCase(mealName)
                _uiState.update { currentState ->
                    currentState.copy(isLoading = false, meals = result)
                }
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(isLoading = false, error = e.message)
                }
            }
        }
    }
}
