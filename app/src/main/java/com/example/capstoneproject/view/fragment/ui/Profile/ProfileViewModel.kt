package com.example.capstoneproject.view.fragment.ui.Profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.capstoneproject.database.repository.Repository

class ProfileViewModel(private val repository: Repository) : ViewModel() {



    private val _text = MutableLiveData<String>().apply {
    }
    val text: LiveData<String> = _text
}