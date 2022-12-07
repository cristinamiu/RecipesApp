package com.example.recipesapp.screens.recipe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.data.DataOrException
import com.example.recipesapp.model.Recipe
import com.example.recipesapp.repository.RecipesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel
@Inject constructor(private val repository: RecipesRepository) :
    ViewModel(){
    val response: MutableState<DataOrException<Recipe, Boolean, Exception>> =
        mutableStateOf(DataOrException())

    fun getRecipeById(id: Int) = viewModelScope.launch {
        response.value = repository.getRecipeById(id = id)
    }
}