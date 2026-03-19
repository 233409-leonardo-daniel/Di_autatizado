
package com.alilopez.kt_demohilt.core.di

import com.alilopez.kt_demohilt.BuildConfig
import com.alilopez.kt_demohilt.core.network.RecipeBookApi
import com.alilopez.kt_demohilt.features.recipebook.data.repositories.MealsRepositoryImpl
import com.alilopez.kt_demohilt.features.recipebook.domain.repositories.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.MEAL_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    @JsonPlaceHolderRetrofit
    fun provideJsonPlaceHolderRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_JSON)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRecipeBookApi(retrofit: Retrofit): RecipeBookApi {
        return retrofit.create(RecipeBookApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMealsRepository(recipeBookApi: RecipeBookApi): MealsRepository {
        return MealsRepositoryImpl(recipeBookApi)
    }
}
