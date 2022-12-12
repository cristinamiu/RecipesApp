package com.example.recipesapp.screens.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.recipesapp.components.RecipesBottomAppBar
import com.example.recipesapp.components.RecipesTopAppBar

@Composable
fun SearchScreen(navController: NavController) {
    SearchScaffold(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScaffold(navController: NavController) {
    Scaffold(
        topBar = { RecipesTopAppBar(navController = navController,
        icon = Icons.Default.ArrowBack) },
        bottomBar = { RecipesBottomAppBar(navController = navController) }
    ) {
        SearchContent(navController = navController,
                      paddingValues = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchContent(navController: NavController,
                  paddingValues: PaddingValues
) {
    TextField(value = "Search Here", onValueChange = {})
}
