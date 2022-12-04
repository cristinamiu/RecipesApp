
package com.example.recipesapp.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.recipesapp.components.RecipeCard
import com.example.recipesapp.components.RecipesBottomAppBar
import com.example.recipesapp.components.RecipesTopAppBar
import com.example.recipesapp.model.RecipesModel
import com.example.recipesapp.screens.favorites.FavoriteViewModel
import com.example.recipesapp.ui.theme.spacing

@Composable
fun RecipesMainScreen(navController: NavController,
                      mainViewModel: MainViewModel,
                      favoriteViewModel: FavoriteViewModel = hiltViewModel()) {

    val queryTag = mainViewModel.queryTag.value
    val res = mainViewModel.response
    if (res.value.loading == true) {
        CircularProgressIndicator()
    } else if(res.value.data != null) {
        MainScaffold(recipesData = res.value.data,
                     navController = navController,
        mainViewModel = mainViewModel,
            favoriteViewModel= favoriteViewModel,
        queryTag = queryTag)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(recipesData: RecipesModel?,
                 navController: NavController,
                 mainViewModel: MainViewModel,
                 favoriteViewModel: FavoriteViewModel,
                 queryTag: String) {
    Scaffold(
        topBar = { RecipesTopAppBar(navController = navController)},
        bottomBar = { RecipesBottomAppBar(navController = navController) }
    ) {
        MainContent(
            recipesData = recipesData,
            paddingValues = it,
            mainViewModel = mainViewModel,
            favoriteViewModel= favoriteViewModel,
            queryTag = queryTag
        )
    }
}

@Composable
fun MainContent(recipesData: RecipesModel?,
                paddingValues: PaddingValues,
                mainViewModel: MainViewModel,
                favoriteViewModel: FavoriteViewModel,
                queryTag: String) {
    Column(modifier = Modifier.padding(paddingValues)) {
        RecipesSearchBar(mainViewModel= mainViewModel, queryTag = queryTag)
        LazyColumn() {
            items(recipesData!!.recipes) {
                RecipeCard(recipe = it, favoriteViewModel= favoriteViewModel)
            }
        }
    }


}

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
private fun RecipesSearchBar(mainViewModel: MainViewModel, queryTag: String) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = Modifier
            .padding(MaterialTheme.spacing.small)
            .fillMaxWidth(),
        value = queryTag, onValueChange = {newValue ->
            mainViewModel.onQueryChanged(newValue)},
        label = { Text(text = "Search")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                mainViewModel.getRecipesByTag(tags = queryTag)
               keyboardController?.hide()
            }
        )


    )
}
