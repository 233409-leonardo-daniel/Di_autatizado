package com.alilopez.kt_demohilt.features.feature01.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.alilopez.kt_demohilt.core.navigation.AppScreens

@Composable
fun HomeScreen(
    navController: NavController, 
    viewModel: HomeViewModel = hiltViewModel()
) {
    val msn by viewModel.msn.collectAsStateWithLifecycle()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)

    ) {
        Text(msn,
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer)
        Button(onClick = {
            navController.navigate(AppScreens.PostsScreen.route)
        }) {
            Text("Go to Posts")
        }
        Button(onClick = {
            navController.navigate(AppScreens.MealsScreen.route)
        }) {
            Text("Go to Recipe")
        }
    }
}