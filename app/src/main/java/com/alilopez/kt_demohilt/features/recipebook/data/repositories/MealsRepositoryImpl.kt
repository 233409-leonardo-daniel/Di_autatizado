package com.alilopez.kt_demohilt.features.recipebook.data.repositories

import com.alilopez.kt_demohilt.core.network.RecipeBookApi
import com.alilopez.kt_demohilt.features.recipebook.data.datasources.remote.mapper.toDomain
import com.alilopez.kt_demohilt.features.recipebook.domain.entities.Meal
import com.alilopez.kt_demohilt.features.recipebook.domain.repositories.MealsRepository

class MealsRepositoryImpl(
    private val api: RecipeBookApi
) : MealsRepository {
    override suspend fun searchMealByName(mealName: String): List<Meal> {
        val response = api.searchMealByName(mealName)
        return response.meals.map { it.toDomain() }
    }

    override suspend fun getMeals(): List<Meal> {
        val response = api.getMeals()
        return response.meals.map { it.toDomain() }
    }
}
