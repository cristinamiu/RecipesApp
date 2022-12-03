package com.example.recipesapp.network

import com.example.recipesapp.model.RecipesModel
import com.example.recipesapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface RecipesApi {

    @GET(value = "recipes/random")
    suspend fun getRandomRecipesByTag(
        @Query("limitLicense") query: Boolean = true,
        @Query("number") number : Int = 2,
        @Query("tags") tags: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): RecipesModel

    @GET(value = "recipes/random")
    suspend fun getRandomRecipes(
        @Query("limitLicense") query: Boolean = true,
        @Query("number") number : Int = 2,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): RecipesModel
}