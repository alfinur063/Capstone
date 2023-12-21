package com.example.capstoneproject.database.api


import android.media.session.MediaSession.Token
import com.example.capstoneproject.database.LoginRequest
import com.example.capstoneproject.database.User
import com.example.capstoneproject.database.response.LoginResponse
import com.example.capstoneproject.database.response.RegisterResponse
import com.example.capstoneproject.database.response.SearchResponse
import com.example.capstoneproject.view.fragment.ui.search.SearchModel
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("register")
    suspend fun register(
        @Body request: User
    ): RegisterResponse

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

//    @GET("foods")
//    suspend fun getAllFoods(): SearchResponse

}

