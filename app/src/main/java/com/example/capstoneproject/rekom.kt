package com.example.capstoneproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rekom(
    val name : String,
    val photo: Int
) : Parcelable
