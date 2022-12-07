package com.example.recipesapp.screens.recipe

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.recipesapp.components.RecipesBottomAppBar
import com.example.recipesapp.components.RecipesTopAppBar


@Composable
fun RecipeDetails(navController: NavController, recipeId: Int
) {
    RecipeDetailsScaffold(navController = navController, recipeId = recipeId)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScaffold(navController: NavController, recipeId: Int) {
    Scaffold(
        topBar = { RecipesTopAppBar(navController = navController,
            icon = Icons.Default.ArrowBack) },
        bottomBar = { RecipesBottomAppBar(navController = navController) }
    ) {
        Text(text = "Recipe Details: $recipeId",
            modifier = Modifier.padding(it))
    }
}