package com.example.capstoneproject.database.api


import com.example.capstoneproject.database.LoginRequest
import com.example.capstoneproject.database.User
import com.example.capstoneproject.database.response.DetailFoodResponse
import com.example.capstoneproject.database.response.FoodResponse
import com.example.capstoneproject.database.response.LoginResponse
import com.example.capstoneproject.database.response.RegisterResponse
import com.example.capstoneproject.view.fragment.ui.search.SearchModel
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("register")
    suspend fun register(
        @Body request: User
    ): RegisterResponse

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse


    @GET("foods/{id_food}")
    suspend fun detailFoods(
        @Path("id_food") id: Int
    ):DetailFoodResponse

    @GET("foods")
    suspend fun foods(): FoodResponse




   // fun recipe(): SearchModel

}

