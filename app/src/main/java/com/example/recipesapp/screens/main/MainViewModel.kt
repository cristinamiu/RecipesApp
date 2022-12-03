package com.example.recipesapp.screens.main

import androidx.lifecycle.ViewModel
import com.example.recipesapp.data.DataOrException
import com.example.recipesapp.model.RecipesModel
import com.example.recipesapp.repository.RecipesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val repository: RecipesRepository)
    : ViewModel() {
        suspend fun getRecipesData(tags: String)
        : DataOrException<RecipesModel, Boolean, Exception>
        {
            return repository.getRecipes(tags = tags)
        }
}