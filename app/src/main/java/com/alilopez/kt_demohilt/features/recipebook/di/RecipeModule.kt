
package com.alilopez.kt_demohilt.features.recipebook.di

import com.alilopez.kt_demohilt.features.recipebook.domain.repositories.MealsRepository
import com.alilopez.kt_demohilt.features.recipebook.domain.usecases.GetMealsUseCase
import com.alilopez.kt_demohilt.features.recipebook.domain.usecases.SearchMealByNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RecipeModule {

    @Provides
    fun provideSearchMealByNameUseCase(mealsRepository: MealsRepository): SearchMealByNameUseCase {
        return SearchMealByNameUseCase(mealsRepository)
    }

    @Provides
    fun provideGetMealsUseCase(mealsRepository: MealsRepository): GetMealsUseCase {
        return GetMealsUseCase(mealsRepository)
    }
}
