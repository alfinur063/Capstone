package com.example.capstoneproject.database.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface AnswerDao {
    @Insert
    suspend fun insertAnswer(userAnswer: Answer)
}