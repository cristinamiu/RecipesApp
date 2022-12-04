package com.example.recipesapp.repository

import android.util.Log
import com.example.recipesapp.data.DataOrException
import com.example.recipesapp.model.RecipesModel
import com.example.recipesapp.network.RecipesApi
import javax.inject.Inject

class RecipesRepository @Inject constructor(private val api: RecipesApi){
    suspend fun getRecipes(tags: String, number: Int = 20)
    : DataOrException<RecipesModel, Boolean, Exception> {
        val response = try {
            api.getRandomRecipesByTag(tags = tags,number = number)
        }
        catch (e: Exception) {
            Log.d("EX", "Exception: $e")
            return DataOrException(e = e)
        }

        return  DataOrException(data = response)
    }

    suspend fun getRandomRecipes(): DataOrException<RecipesModel, Boolean, Exception> {
        val response = try {
            api.getRandomRecipes()
        }
        catch (e: Exception) {
            Log.d("EX", "Exception: $e")
            return DataOrException(e = e)
        }

        return  DataOrException(data = response)
    }
}