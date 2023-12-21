package com.example.capstoneproject.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface AnswerDao {
    @Insert
    suspend fun insertAnswer(userAnswer: Answer)

    @Query("SELECT * FROM inputUser")
    suspend fun getAllAnswerUser(): List<Answer>
}