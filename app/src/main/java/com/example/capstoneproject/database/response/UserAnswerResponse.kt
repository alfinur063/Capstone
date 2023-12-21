package com.example.capstoneproject.database.response

import com.google.gson.annotations.SerializedName

data class UserAnswerResponse(

    @field:SerializedName("listAnswer")
    val listUserAnswer: List<Int>,

//    @field:SerializedName("error")
//    val error: String

)
