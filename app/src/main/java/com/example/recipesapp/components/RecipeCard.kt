package com.example.recipesapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipesapp.model.Recipe
import com.example.recipesapp.ui.theme.spacing

@Composable
fun RecipeCard(recipe: Recipe,
               onClick: () -> Unit = {}) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = MaterialTheme.spacing.small,
                top = MaterialTheme.spacing.small
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(MaterialTheme.spacing.small)
    ) {
        Text(text = recipe.title)
        Text(text = recipe.imageType)
    }
}