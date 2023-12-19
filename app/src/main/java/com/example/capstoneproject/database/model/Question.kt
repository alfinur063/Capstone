package com.example.capstoneproject.database.model

import android.content.Context
import android.widget.Button
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Question1 (
    val id: Int,
    val gender: String,
    val age: Int,
    val everMarried: String,
    val workType: String,
    val residenceType: String,
    val bmi: String,
    val smokingStatus: String,
    val physicalActivity: String,
)

data class listQuestion(
    val id: Int,
    val question : String,
    val optionsOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,
)

data class listQuestion2(
    val id: Int,
    val question: String,
    val listOpstions : List<String>
)


//fun LoadQuestion(context: Context): List<Question>{
//    val jsonString = context.assets.open("question.json").bufferedReader().use { it.readText() }
//    val type = object : TypeToken<List<Question>>() {}.type
//    return Gson().fromJson(jsonString, type)
//}