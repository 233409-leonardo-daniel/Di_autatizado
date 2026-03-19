package com.alilopez.kt_demohilt.features.recipebook.domain.repositories


import com.alilopez.kt_demohilt.features.recipebook.domain.entities.Meal

interface MealsRepository {
    suspend fun searchMealByName(mealName: String): List<Meal>
    suspend fun getMeals(): List<Meal>
}
