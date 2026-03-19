package com.alilopez.kt_demohilt.core.network

import com.alilopez.kt_demohilt.features.recipebook.data.datasources.remote.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeBookApi {
    @GET("api/json/v1/1/search.php")
    suspend fun searchMealByName(@Query("s") mealName: String): MealResponse

    @GET("api/json/v1/1/search.php?s=a")
    suspend fun getMeals(): MealResponse
}