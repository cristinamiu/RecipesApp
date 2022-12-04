package com.example.recipesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recipesapp.model.Favorite

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class RecipesDatabase: RoomDatabase() {
    abstract fun recipesDao(): RecipesDAO
}