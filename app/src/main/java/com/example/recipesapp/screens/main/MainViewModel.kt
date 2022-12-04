package com.example.recipesapp.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.data.DataOrException
import com.example.recipesapp.model.RecipesModel
import com.example.recipesapp.repository.RecipesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.http.Query
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val repository: RecipesRepository)
    : ViewModel() {
    val response: MutableState<DataOrException<RecipesModel, Boolean, Exception>> =
        mutableStateOf(DataOrException())

    val queryTag = mutableStateOf("")

    init {
        getRandomRecipes()
    }
        suspend fun getRecipesData(tags: String)
        : DataOrException<RecipesModel, Boolean, Exception>
        {
            return repository.getRecipes(tags = tags)
        }

    private fun getRandomRecipes() {
        viewModelScope.launch {
            response.value = repository.getRandomRecipes()
        }
    }
    fun getRecipesByTag(tags: String) {
        viewModelScope.launch {
            response.value = repository.getRecipes(tags= tags)
        }
    }

    fun onQueryChanged(newQuery: String) {
        queryTag.value = newQuery
    }
}