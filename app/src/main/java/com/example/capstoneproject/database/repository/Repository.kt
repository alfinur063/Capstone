package com.example.capstoneproject.database.repository

import android.app.Service
import androidx.lifecycle.liveData
import com.example.capstoneproject.database.api.ApiService
import com.example.capstoneproject.database.preference.UserModel
import com.example.capstoneproject.database.preference.UserPreference
import com.example.capstoneproject.database.response.LoginResponse
import com.example.capstoneproject.database.response.RegisterResponse
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.util.prefs.Preferences


class Repository private constructor(
    private val apiService: ApiService,
    private val preferences: UserPreference
) {
//    fun login(email: String, password: String) = liveData<ResultState<LoginResponse>> {
//        emit(ResultState.Loading)
//        try {
//            val successResponse = apiService.login(email, password)
//            val userModel = UserModel(successResponse.loginResult.name, successResponse.loginResult.token, true)
//            saveSession(userModel)
//            emit(ResultState.Success(successResponse))
//        } catch (e: HttpException) {
//            val errorBody = e.response()?.errorBody()?.string()
//            val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
//            emit(ResultState.Error(errorResponse.message))
//        }
//    }

    fun register(name: String, email: String, password: String) = liveData{
        emit(ResultState.Loading)
        try {
            val successResponse = apiService.register(name, email, password)
            emit(ResultState.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, RegisterResponse::class.java)
            emit(ResultState.Error(errorResponse.message))
        }
    }

    suspend fun saveSession(user: UserModel){
        preferences.saveSession(user)
    }
    fun getSession(): Flow<UserModel> {
        return preferences.getSession()
    }
    suspend fun logout(){
        preferences.removeSession()
    }

    companion object{
        private var instance: Repository? = null
        fun getInstance(apiService: ApiService, preferences: UserPreference) : Repository{
            if (instance == null){
                instance = Repository(apiService, preferences)
            }
            return instance!!
        }
    }
}