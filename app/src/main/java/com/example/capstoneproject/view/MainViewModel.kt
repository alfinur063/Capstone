package com.example.capstoneproject.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.capstoneproject.database.preference.UserModel
import com.example.capstoneproject.database.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
}