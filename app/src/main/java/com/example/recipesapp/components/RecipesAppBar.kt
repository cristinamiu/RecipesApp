package com.example.recipesapp.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.recipesapp.widgets.RecipesLogo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesTopAppBar() {
    CenterAlignedTopAppBar(
        title = { RecipesLogo() },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant))
}

