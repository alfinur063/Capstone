package com.example.capstoneproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class  Recipe(
    var titlerecipe: String,
    var description: String,
    var imagerecipe: Int,
):Parcelable