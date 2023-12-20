package com.example.capstoneproject.database.di

import android.content.Context
import com.example.capstoneproject.database.api.ApiConfig
import com.example.capstoneproject.database.preference.UserPreference
import com.example.capstoneproject.database.preference.dataStore
import com.example.capstoneproject.database.repository.Repository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): Repository{
        val preferences = UserPreference.getInstance(context.dataStore)
        val token = runBlocking {
            preferences.getSession().first().token
        }
        val apiService = ApiConfig.getApiService(token)
        return Repository.getInstance(apiService, preferences, true)!!
    }
}