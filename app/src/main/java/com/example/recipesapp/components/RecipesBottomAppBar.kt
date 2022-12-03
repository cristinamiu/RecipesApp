package com.example.recipesapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.recipesapp.navigation.RecipesScreens

@Composable
fun RecipesBottomAppBar(navController: NavController) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        IconButton(onClick = { navController.navigate(RecipesScreens.MainScreen.name) },
        modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Default.Home,
                contentDescription = "Search Button"
                )
        }

        IconButton(onClick = { navController.navigate(RecipesScreens.SearchScreen.name) },
        modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Rounded.Search,
                contentDescription = "Search Button")
        }

        IconButton(onClick = { navController.navigate(RecipesScreens.FavoriteScreen.name)},
            modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Default.Favorite,
                contentDescription = "Search Button")
        }
    }
}