package com.example.recipesapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipesapp.screens.main.MainViewModel
import com.example.recipesapp.screens.main.RecipesMainScreen
import com.example.recipesapp.screens.splash.RecipesSplashScreen

@Composable
fun RecipesNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = RecipesScreens.SplashScreen.name) {

        composable(RecipesScreens.SplashScreen.name) {
            RecipesSplashScreen(navController = navController)
        }
        
        composable(RecipesScreens.MainScreen.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            RecipesMainScreen(navController = navController, mainViewModel)
        }
    }
}
