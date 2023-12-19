package com.example.capstoneproject.database.api


import com.example.capstoneproject.database.request.LoginRequest
import com.example.capstoneproject.database.response.LoginResponse
import com.example.capstoneproject.database.response.RegisterResponse
import com.example.capstoneproject.view.fragment.ui.search.SearchViewModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseBody>



    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @GET("foods")
    fun recipe(): Call<SearchViewModel>

}

