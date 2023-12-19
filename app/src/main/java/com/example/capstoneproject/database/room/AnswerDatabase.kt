package com.example.capstoneproject.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Answer::class], version = 1)
abstract class AnswerDatabase : RoomDatabase(){
    abstract fun userAnswerDao(): AnswerDao

    companion object{
        @Volatile
        private var INSTANCE: AnswerDatabase? = null

        fun getDatabase(context: Context): AnswerDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnswerDatabase::class.java,
                    "user_answer_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
