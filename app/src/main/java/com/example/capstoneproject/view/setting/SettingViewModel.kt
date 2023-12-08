package com.example.capstoneproject.view.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.database.repository.Repository
import kotlinx.coroutines.launch

class SettingViewModel (private val repository : Repository) : ViewModel(){

    fun logout(){
        viewModelScope.launch {
            repository.logout()
        }
    }
}