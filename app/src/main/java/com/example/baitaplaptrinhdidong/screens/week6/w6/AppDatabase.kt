package com.example.baitaplaptrinhdidong.screens.week6.w6

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.baitaplaptrinhdidong.screens.week6.w6.model.Task
import com.example.baitaplaptrinhdidong.screens.week6.w6.model.TaskDao

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class  AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}