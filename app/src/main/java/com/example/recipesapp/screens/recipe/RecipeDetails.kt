package com.example.recipesapp.screens.recipe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.recipesapp.components.RecipesBottomAppBar
import com.example.recipesapp.components.RecipesTopAppBar
import com.example.recipesapp.data.DataOrException
import com.example.recipesapp.model.Recipe


@Composable
fun RecipeDetails(navController: NavController, recipeId: Int
) {
    RecipeDetailsScaffold(navController = navController, recipeId = recipeId)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScaffold(navController: NavController,
                          recipeId: Int,
                          recipeDetailsViewModel: RecipeDetailsViewModel = hiltViewModel()) {
    Scaffold(
        topBar = { RecipesTopAppBar(navController = navController,
            icon = Icons.Default.ArrowBack) },
        bottomBar = { RecipesBottomAppBar(navController = navController) }
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            RecipeDetails(recipeId = recipeId, recipeDetailsViewModel = recipeDetailsViewModel)
        }
    }
}

@Composable
fun RecipeDetails(recipeId: Int,
                  recipeDetailsViewModel: RecipeDetailsViewModel) {
    recipeDetailsViewModel.getRecipeById(recipeId)
    val response = recipeDetailsViewModel.response.value

    ShowRecipeDetails(response)
}

@Composable
fun ShowRecipeDetails(response: DataOrException<Recipe, Boolean, Exception>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = response.data?.image)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Recipes Image",
        )
        response.data?.let { Text(text = it.title) }

        ShowIngredients(response)
        ShowInstructions(response = response)
    }
}

@Composable
private fun ShowIngredients(response: DataOrException<Recipe, Boolean, Exception>) {
    Text(text = "Ingredients:")

    LazyColumn() {
        response.data?.let { it ->
            items(it.extendedIngredients) {
                Text(text = "${it.name}, ${it.amount}")
            }
        }
    }
}

@Composable
private fun ShowInstructions(response: DataOrException<Recipe, Boolean, Exception>) {
    Text(text = "Instructions:")

    response.data?.let { Text(text = it.instructions) }
}
