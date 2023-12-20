package com.example.capstoneproject.database.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "inputUser")
data class Answer (
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val questionIndex: Int,
    val answerIndex: Int
)