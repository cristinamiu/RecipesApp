package com.example.recipesapp.screens.favorites

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.recipesapp.components.RecipesBottomAppBar
import com.example.recipesapp.components.RecipesTopAppBar

@Composable
fun RecipesFavoritesScreen(navController: NavController
) {
    FavoritesScaffold(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScaffold(navController: NavController) {
    Scaffold(
        topBar = { RecipesTopAppBar(navController = navController,
            icon = Icons.Default.ArrowBack) },
        bottomBar = { RecipesBottomAppBar(navController = navController) }
    ) {
        FavoriteContent(navController = navController,
                      paddingValues = it)
    }
}

@Composable
fun FavoriteContent(navController: NavController,
                    paddingValues: PaddingValues
) {}
