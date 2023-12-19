package com.example.capstoneproject.view.fragment.ui.search

import android.icu.text.CaseMap.Title

data class SearchModel(
    val result: ArrayList<Result>
){
    data class Result (val id_food: Int, val food_name: String, val image: String)
}
