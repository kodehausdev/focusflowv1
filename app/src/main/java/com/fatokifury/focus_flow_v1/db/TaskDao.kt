package com.fatokifury.focus_flow_v1.db // Or your chosen package

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow // For reactive updates

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Replace if primary key conflicts
    suspend fun insertTask(task: Task) // suspend for coroutines

    @Query("SELECT * FROM tasks ORDER BY timestamp DESC")
    fun getAllTasks(): Flow<List<Task>> // Returns a Flow for reactive UI updates

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    suspend fun getTaskById(taskId: Int): Task?

    @Query("DELETE FROM tasks WHERE id = :taskId")
    suspend fun deleteTaskById(taskId: Int)

    @Query("UPDATE tasks SET isCompleted = :completed WHERE id = :taskId")
    suspend fun updateTaskCompletion(taskId: Int, completed: Boolean)
}
