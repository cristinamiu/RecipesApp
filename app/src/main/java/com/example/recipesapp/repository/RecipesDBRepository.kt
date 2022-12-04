package com.example.recipesapp.repository

import com.example.recipesapp.data.RecipesDAO
import com.example.recipesapp.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipesDBRepository @Inject constructor(private val recipesDAO: RecipesDAO) {
    fun getFavorites(): Flow<List<Favorite>> = recipesDAO.getFavorites()
    suspend fun insertFavorite(favorite: Favorite) = recipesDAO.insertFavorite(favorite)
    suspend fun updateFavorite(favorite: Favorite) = recipesDAO.updateFavorite(favorite)
    suspend fun deleteAllFavorites() = recipesDAO.deleteAllFavorites()
    suspend fun deleteFavorite(favorite: Favorite) = recipesDAO.deleteFavorite(favorite)
    suspend fun getFavoriteById(id: Int) = recipesDAO.getFavById(id)
}