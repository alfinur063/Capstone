package com.example.capstoneproject.database.di

import android.content.Context
import com.example.capstoneproject.database.repository.Repository
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): Repository{
        val preferences = //userPreferences
        val token = runBlocking {
            //pref.getsession().first().token
        }
        //val apiService = ApiConfig.getApiService(token)
        return Repository //.getInstance(apiservice, pref)
    }
}