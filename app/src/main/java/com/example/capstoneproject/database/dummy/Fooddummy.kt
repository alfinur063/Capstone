package com.example.capstoneproject.database.dummy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fooddummy (
    var name: String = "",
    var desc: String = "",
    var photo : Int = 0,
    var khasiat : String = "",
    var bahan: String = "",
    var step: String = ""
) : Parcelable