package com.alilopez.kt_demohilt.features.recipebook.data.datasources.remote.mapper

import com.alilopez.kt_demohilt.features.recipebook.data.datasources.remote.model.MealDto
import com.alilopez.kt_demohilt.features.recipebook.domain.entities.Meal

fun MealDto.toDomain(): Meal {
    return Meal(
        id = id,
        name = name,
        instructions = instructions,
        imageUrl = imageUrl
    )
}
