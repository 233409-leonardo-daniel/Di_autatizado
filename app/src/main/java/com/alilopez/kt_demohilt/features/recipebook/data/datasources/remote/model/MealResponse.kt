
package com.alilopez.kt_demohilt.features.recipebook.data.datasources.remote.model


import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("meals")
    val meals: List<MealDto>
)
