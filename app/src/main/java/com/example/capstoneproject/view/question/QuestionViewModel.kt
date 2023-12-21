package com.example.capstoneproject.view.question

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.database.repository.Repository
import com.google.gson.Gson
import com.google.gson.JsonArray

class QuestionViewModel(private val repository: Repository): ViewModel() {
    private val userAnswers = mutableListOf<Int>()

    fun addUsersAnswer(answer: Int){
        userAnswers.add(answer)
    }

    fun getUserAnswersAsJsonArray(): JsonArray{
        val gson = Gson()
        val jsonArray = JsonArray()
        userAnswers.forEach{
            jsonArray.add(gson.toJsonTree(it))
        }
        return jsonArray
    }

}