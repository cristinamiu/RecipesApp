
package com.example.recipesapp.screens.main

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.navigation.NavController
import com.example.recipesapp.data.DataOrException
import com.example.recipesapp.model.RecipesModel

@Composable
fun RecipesMainScreen(navController: NavController,
                      mainViewModel: MainViewModel) {
    ShowData(mainViewModel)
}

@Composable
fun ShowData(mainViewModel: MainViewModel) {
    val recipesData = produceState<DataOrException<RecipesModel, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = mainViewModel.getRecipesData(tags = "cake")
    }.value

    if (recipesData.loading == true) {
        CircularProgressIndicator()
    } else if(recipesData.data != null) {
        Text(text = "Main Screen: ${recipesData.data!!.recipes.first().title}")
    }
}
