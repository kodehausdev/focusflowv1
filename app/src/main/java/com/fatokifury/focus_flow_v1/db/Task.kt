package com.fatokifury.focus_flow_v1.db // Or your chosen package

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks") // Defines the table name
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // Auto-generated primary key
    val title: String,
    val description: String? = null,
    val isCompleted: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)