package com.example.recipesapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.recipesapp.model.Recipe
import com.example.recipesapp.ui.theme.spacing
import com.example.recipesapp.utils.DisplayHtml

@Composable
fun RecipeCard(recipe: Recipe,
               onClick: () -> Unit = {}) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(MaterialTheme.spacing.small)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = ImageRequest.Builder(LocalContext.current)
                                .data(data = recipe.image)
                .crossfade(true)
                                .build(),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Recipes Image",
        )
        Spacer(modifier = Modifier.padding(MaterialTheme.spacing.extraSmall))
        Text(text = recipe.title,
        style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(MaterialTheme.spacing.small))
        Text(text = "${DisplayHtml(text = recipe.summary).substring(IntRange(0, 200))}...",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(MaterialTheme.spacing.small))
        

    }
}