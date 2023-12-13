package com.example.capstoneproject

import android.icu.text.CaseMap.Title
import android.media.Image
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class  Recipe(
    var imageRecipe: Int,
    var titleRecipe: String,
    var descRecipe: String
):Parcelable