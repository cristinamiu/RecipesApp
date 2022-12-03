
package com.example.recipesapp.screens.main

import androidx.compose.foundation.layout.Column
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
        Column() {
            recipesData.data!!.recipes.forEach{ 
                Text(text = it.title)
            }
        }
    }
}
