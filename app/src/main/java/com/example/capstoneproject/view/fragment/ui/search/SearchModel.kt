package com.example.capstoneproject.view.fragment.ui.search

import android.icu.text.CaseMap.Title
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.capstoneproject.database.preference.UserModel
import com.example.capstoneproject.database.repository.Repository

data class SearchModel(private val repository: Repository):ViewModel(){
    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
        fun listOfFood() = repository.foods()

    //data class Result (val id_food: Int, val food_name: String, val image: String)
}
