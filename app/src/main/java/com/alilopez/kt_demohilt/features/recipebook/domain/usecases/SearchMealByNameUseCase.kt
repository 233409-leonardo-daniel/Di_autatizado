package com.alilopez.kt_demohilt.features.recipebook.domain.usecases

import com.alilopez.kt_demohilt.features.recipebook.domain.repositories.MealsRepository

class SearchMealByNameUseCase(private val repository: MealsRepository) {
    suspend operator fun invoke(mealName: String) = repository.searchMealByName(mealName)
}
