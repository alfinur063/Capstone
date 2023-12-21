package com.example.capstoneproject.view.fragment.detail

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.database.repository.Repository

class DetailViewModel(private val repository: Repository): ViewModel() {
    fun goToDetail(id: Int) = repository.detailFoods(id)
}