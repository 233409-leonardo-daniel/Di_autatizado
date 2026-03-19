package com.alilopez.kt_demohilt.features.recipebook.domain.usecases

import com.alilopez.kt_demohilt.features.recipebook.domain.entities.Meal
import com.alilopez.kt_demohilt.features.recipebook.domain.repositories.MealsRepository

class GetMealsUseCase(
    private val repository: MealsRepository
) {
    suspend operator fun invoke(): List<Meal> {
        return repository.getMeals()
    }
}
