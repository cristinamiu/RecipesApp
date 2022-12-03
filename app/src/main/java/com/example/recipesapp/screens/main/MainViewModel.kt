package com.example.recipesapp.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipesapp.data.DataOrException
import com.example.recipesapp.model.RecipesModel
import com.example.recipesapp.repository.RecipesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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