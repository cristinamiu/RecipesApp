package com.example.recipesapp.di

import android.content.Context
import androidx.room.Room
import com.example.recipesapp.data.RecipesDAO
import com.example.recipesapp.data.RecipesDatabase
import com.example.recipesapp.network.RecipesApi
import com.example.recipesapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideRecipesDao(recipesDatabase: RecipesDatabase) : RecipesDAO
    = recipesDatabase.recipesDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): RecipesDatabase
    = Room.databaseBuilder(context, RecipesDatabase::class.java, "recipes_database")
        .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideRecipesApi(): RecipesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipesApi::class.java)
    }
}