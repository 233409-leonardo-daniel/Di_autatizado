package com.alilopez.kt_demohilt.core.di

import android.content.Context
import com.alilopez.kt_demohilt.BuildConfig
import com.alilopez.kt_demohilt.core.network.RecipeBookApi
import com.alilopez.kt_demohilt.features.recipebook.data.repositories.MealsRepositoryImpl
import com.alilopez.kt_demohilt.features.recipebook.domain.repositories.MealsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer (context: Context){


    private val mealRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.MEAL_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()





    val recipeApi: RecipeBookApi by lazy {
        mealRetrofit.create(RecipeBookApi::class.java)
    }

    val mealsRepository: MealsRepository by lazy {
        MealsRepositoryImpl(recipeApi)
    }
}