package com.alilopez.kt_demohilt.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alilopez.demo.features.jsonplaceholder.presentation.screens.PostsScreen
import com.alilopez.kt_demohilt.features.feature01.presentation.HomeScreen
import com.alilopez.kt_demohilt.features.recipebook.presentation.screens.MealsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.route
    ) {
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(AppScreens.PostsScreen.route) {
            PostsScreen(navController = navController)
        }
        composable(AppScreens.MealsScreen.route){
            MealsScreen(navController = navController)
        }
    }
}
