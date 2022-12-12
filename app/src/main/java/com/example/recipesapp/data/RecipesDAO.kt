package com.example.recipesapp.data

import androidx.room.*
import com.example.recipesapp.model.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDAO {
    @Query("SELECT * from favorite_table")
    fun getFavorites(): Flow<List<Favorite>>

    @Query("SELECT * from favorite_table where id =:id")
    suspend fun getFavById(id: Int): Favorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(favorite: Favorite)

    @Query("DELETE from favorite_table")
    suspend fun deleteAllFavorites()

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}