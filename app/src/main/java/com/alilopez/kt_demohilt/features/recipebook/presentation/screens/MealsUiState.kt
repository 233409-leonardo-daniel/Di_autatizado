package com.alilopez.kt_demohilt.features.recipebook.presentation.screens

import com.alilopez.kt_demohilt.features.recipebook.domain.entities.Meal

data class MealsUiState(
    val isLoading: Boolean = false,
    val meals: List<Meal> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)
