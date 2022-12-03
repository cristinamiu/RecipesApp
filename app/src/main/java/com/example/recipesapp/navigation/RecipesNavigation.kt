package com.example.recipesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipesapp.screens.RecipesMainScreen
import com.example.recipesapp.screens.RecipesSplashScreen

@Composable
fun RecipesNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = RecipesScreens.SplashScreen.name) {

        composable(RecipesScreens.SplashScreen.name) {
            RecipesSplashScreen(navController = navController)
        }
        
        composable(RecipesScreens.MainScreen.name) {
            RecipesMainScreen(navController = navController)
        }
    }
}
