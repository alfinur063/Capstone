package com.example.capstoneproject.database.repository

import android.app.Service
import androidx.lifecycle.liveData
import java.util.prefs.Preferences


class Repository private constructor(
    private val apiService: Service, //must be ApiService
    private val preferences: Preferences //must be UserPreference
){
    fun login(email: String, password: String) = liveData<> {
        emit(ResultState.Loading)
        try {
            val successResponse = apiService
            val userModel = UserModel(successResponse.login)
        }
    }
}