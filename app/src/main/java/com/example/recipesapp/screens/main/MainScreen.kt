
package com.example.recipesapp.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.recipesapp.components.RecipesBottomAppBar
import com.example.recipesapp.components.RecipesTopAppBar
import com.example.recipesapp.data.DataOrException
import com.example.recipesapp.model.RecipesModel

@Composable
fun RecipesMainScreen(navController: NavController,
                      mainViewModel: MainViewModel) {

    val recipesData = produceState<DataOrException<RecipesModel, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = mainViewModel.getRecipesData(tags = "cake")
    }.value

    if (recipesData.loading == true) {
        CircularProgressIndicator()
    } else if(recipesData.data != null) {
        MainScaffold(recipesData = recipesData.data,
                     navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(recipesData: RecipesModel?,
                 navController: NavController) {
    Scaffold(
        topBar = { RecipesTopAppBar(navController = navController)},
        bottomBar = { RecipesBottomAppBar(navController = navController) }
    ) {
        MainContent(
            recipesData = recipesData,
            paddingValues = it
        )
    }
}

@Composable
fun MainContent(recipesData: RecipesModel?,
                paddingValues: PaddingValues) {
    Column(modifier = Modifier.padding(paddingValues)) {
        recipesData!!.recipes.forEach{
            Text(text = it.title)
        }
    }

}
