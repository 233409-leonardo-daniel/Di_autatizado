package com.alilopez.kt_demohilt.features.recipebook.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alilopez.kt_demohilt.features.recipebook.domain.usecases.GetMealsUseCase
import com.alilopez.kt_demohilt.features.recipebook.domain.usecases.SearchMealByNameUseCase

class MealsViewModelFactory(
    private val searchMealByNameUseCase: SearchMealByNameUseCase,
    private val getMealsUseCase: GetMealsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MealsViewModel(searchMealByNameUseCase, getMealsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
