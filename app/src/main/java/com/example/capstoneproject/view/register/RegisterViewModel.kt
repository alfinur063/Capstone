package com.example.capstoneproject.view.register

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.database.repository.Repository

class RegisterViewModel(private val repository: Repository): ViewModel() {
    fun register(name: String, email: String, password: String) = repository.register(name,email, password)

}