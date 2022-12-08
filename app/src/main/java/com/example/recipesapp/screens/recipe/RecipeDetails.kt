package com.example.recipesapp.screens.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
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
import com.example.recipesapp.ui.theme.spacing
import com.example.recipesapp.utils.DisplayHtml


@Composable
fun RecipeDetails(
    navController: NavController
) {
    RecipeDetailsScaffold(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScaffold(
    navController: NavController,
    recipeDetailsViewModel: RecipeDetailsViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = { RecipesTopAppBar(navController = navController,
            icon = Icons.Default.ArrowBack) },
        bottomBar = { RecipesBottomAppBar(navController = navController) }
    ) {
        rememberScrollState()

        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            RecipeDetails(recipeDetailsViewModel = recipeDetailsViewModel)
        }
    }
}

@Composable
fun RecipeDetails(recipeDetailsViewModel: RecipeDetailsViewModel) {
    val response = recipeDetailsViewModel.response.value
    ShowRecipeDetails(response)
}

@Composable
fun ShowRecipeDetails(response: DataOrException<Recipe, Boolean, Exception>) {
    Column(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {
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
        response.data?.let { Text(text = it.title,
        style = MaterialTheme.typography.displayMedium) }



            ShowIngredients(response)
            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.medium))
            ShowInstructions(response = response)




    }
}

@Composable
private fun ShowIngredients(response: DataOrException<Recipe, Boolean, Exception>) {
    Text(
        text = "Ingredients:",
        style = MaterialTheme.typography.headlineMedium
    )

    Column() {
        response.data?.extendedIngredients?.forEach { ingredient ->
            Text(text = "${ingredient.name} - ${ingredient.amount}")
        }
    }
}


@Composable
private fun ShowInstructions(response: DataOrException<Recipe, Boolean, Exception>) {
    Text(
        text = "Instructions:",
        style = MaterialTheme.typography.headlineMedium
    )

    response.data?.let {
        Text(text = DisplayHtml(text = response.data!!.instructions))
    }
}
