package com.fatokifury.focus_flow_v1.db // Or your chosen package

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false) // Add your entities here, set exportSchema
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao // Abstract method to get the DAO

    companion object {
        // Volatile to ensure visibility of changes across threads
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // Return instance if it exists, otherwise create it synchronized to be thread-safe
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "focus_flow_database" // Name of your database file
                )
                    // .addMigrations(...) // If you have migrations later
                    .fallbackToDestructiveMigration() // For simple testing, recreates DB if schema changes (NOT FOR PRODUCTION without care)
                    .build()
                INSTANCE = instance
                instance // Return the instance
            }
        }
    }
}