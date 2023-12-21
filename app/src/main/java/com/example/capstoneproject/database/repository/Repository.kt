package com.example.capstoneproject.database.repository

import android.app.Service
import android.util.Log
import androidx.lifecycle.liveData
import com.example.capstoneproject.database.LoginRequest
import com.example.capstoneproject.database.User
import com.example.capstoneproject.database.api.ApiService
import com.example.capstoneproject.database.preference.UserModel
import com.example.capstoneproject.database.preference.UserPreference
import com.example.capstoneproject.database.response.DetailFoodResponse
import com.example.capstoneproject.database.response.FoodResponse
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
    fun login(email: String, password: String) = liveData<ResultState<LoginResponse>> {
        emit(ResultState.Loading)
        try {
            val successResponse = apiService.login(LoginRequest(email, password))
            val userModel = UserModel(successResponse.accessToken,successResponse.accessToken,true)
            saveSession(userModel)
            emit(ResultState.Success(successResponse))
            Log.d("tessss", successResponse.toString())
        } catch (e: HttpException) {
            Log.d("testtt", e.toString())
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
            emit(ResultState.Error(errorResponse.toString()))
        }
    }

    fun register(name: String, email: String, password: String) = liveData{
        emit(ResultState.Loading)
//        Log.d("register mantap", name)
//        Log.d("register mantap", email)
//        Log.d("register mantap", password)
        try {
            val successResponse = apiService.register(User(name, email, password))
            emit(ResultState.Success(successResponse))
        } catch (e: HttpException) {
            Log.d("register", e.toString())
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, RegisterResponse::class.java)
            emit(ResultState.Error(errorResponse.message))
        }
    }

    fun foods() = liveData {
        emit(ResultState.Loading)
        try {
            val successResponse = apiService.foods()
            emit(ResultState.Success(successResponse))
        }catch (e: HttpException){
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, FoodResponse::class.java)
            emit(ResultState.Error(errorResponse.toString()))
        }
    }

    fun detailFoods(id: Int) = liveData {
        emit(ResultState.Loading)
        try {
            val successResponse = apiService.detailFoods(id)
            emit(ResultState.Success(successResponse))
        }catch (e: HttpException){
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, DetailFoodResponse::class.java)
            emit(ResultState.Error(errorResponse.toString()))
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

//    companion object{
//        private var instance: Repository? = null
//        fun getInstance(apiService: ApiService, preferences: UserPreference) : Repository{
//            if (instance == null){
//                instance = Repository(apiService, preferences)
//            }
//            return instance!!
//        }

        companion object {
            private var instance: Repository? = null
//        fun getInstance(apiService: ApiService, preferences: UserPreference): StoryRepo{
//            if (instance == null){
//                instance = StoryRepo(apiService, preferences)
//            }
//            return instance!!
//        }
//    }

            fun getInstance(
                apiService: ApiService,
                preference: UserPreference,
                Needed: Boolean
            ): Repository? {
                if (preference == null || Needed) {
                    synchronized(this) {
                        instance = Repository(apiService, preference)
                    }
                }
                return instance!!
            }
        }

    }
