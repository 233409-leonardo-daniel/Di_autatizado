package com.alilopez.kt_demohilt.core.navigation

sealed class AppScreens(val route: String) {
    object HomeScreen: AppScreens("home_screen")
    object PostsScreen: AppScreens("posts_screen")

    object MealsScreen: AppScreens("meals_screen")

}