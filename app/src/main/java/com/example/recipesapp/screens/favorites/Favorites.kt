package com.example.recipesapp.screens.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.recipesapp.components.RecipesBottomAppBar
import com.example.recipesapp.components.RecipesTopAppBar
import com.example.recipesapp.model.Favorite
import com.example.recipesapp.navigation.RecipesScreens
import com.example.recipesapp.ui.theme.spacing

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
                    paddingValues: PaddingValues,
                    favoriteViewModel: FavoriteViewModel = hiltViewModel()
) {
    Surface(modifier = Modifier
        .padding(paddingValues)
        .fillMaxWidth()) {
        Column(verticalArrangement = Arrangement.Top) {
            val listFav = favoriteViewModel.favList.collectAsState().value

            LazyColumn {
                items(listFav, key = {favRecipe -> favRecipe.id}) { recipe ->
                    RecipeRow(recipe, navController = navController, favoriteViewModel)
                }
            }
        }
    }
}

@Composable
fun RecipeRow(recipe: Favorite,
              navController: NavController,
              favoriteViewModel: FavoriteViewModel) {
    Surface(
        Modifier
            .padding(MaterialTheme.spacing.extraSmall)
            .fillMaxWidth()
            .height(50.dp)
            .clickable { navController.navigate("${RecipesScreens.RecipeDetails.name}/${recipe.id}") },
    shape = CircleShape.copy(topEnd = CornerSize(MaterialTheme.spacing.small)),
    color = MaterialTheme.colorScheme.surfaceVariant) {


        Row(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(3f)) {
                Text(text = recipe.name,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Icon(imageVector = Icons.Rounded.Delete,
                    contentDescription = "Delete",
                    modifier = Modifier.align(Alignment.End)
                        .clickable {
                            favoriteViewModel.deleteFavorite(recipe)
                        })
            }


        }
    }
}
