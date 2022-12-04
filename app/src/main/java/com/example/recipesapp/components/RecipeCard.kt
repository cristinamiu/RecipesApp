package com.example.recipesapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.recipesapp.model.Favorite
import com.example.recipesapp.model.Recipe
import com.example.recipesapp.screens.favorites.FavoriteViewModel
import com.example.recipesapp.ui.theme.spacing
import com.example.recipesapp.utils.DisplayHtml

@Composable
fun RecipeCard(recipe: Recipe,
               favoriteViewModel: FavoriteViewModel,
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
        Box(contentAlignment = Alignment.TopEnd) {


            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = recipe.image)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.FillWidth,
                contentDescription = "Recipes Image",
            )
            Icon(imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Favorite Icon",
                modifier = Modifier.scale(1.5f)
                    .padding(MaterialTheme.spacing.small)
                    .clickable { favoriteViewModel.insertFavorite(Favorite(
                        id = recipe.id,
                        name = recipe.title
                    )) })
        }

        Spacer(modifier = Modifier.padding(MaterialTheme.spacing.extraSmall))

        Text(text = recipe.title,
        style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(MaterialTheme.spacing.small))
        Text(text = "${DisplayHtml(text = recipe.summary).substring(IntRange(0, 200))}...",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(MaterialTheme.spacing.small))
        

    }
}