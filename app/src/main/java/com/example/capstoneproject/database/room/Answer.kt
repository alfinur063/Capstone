package com.example.capstoneproject.database.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "inputUser")
data class Answer (
    @PrimaryKey(autoGenerate = false)
    val questionIndex: Int,
    val answerIndex: Int
)