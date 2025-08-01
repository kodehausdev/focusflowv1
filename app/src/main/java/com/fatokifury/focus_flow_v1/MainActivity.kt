//
//package com.fatokifury.focus_flow_v1
//
//
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.lifecycle.lifecycleScope
//import com.fatokifury.focus_flow_v1.db.TaskDao
//import com.fatokifury.focus_flow_v1.db.AppDatabase
//import com.fatokifury.focus_flow_v1.db.Task
//import com.fatokifury.focus_flow_v1.ui.theme.FocusFlowv1Theme
//import kotlinx.coroutines.DelicateCoroutinesApi
//// ... rest of your imports and code
//
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope // For simple test, not recommended for production
//import kotlinx.coroutines.flow.firstOrNull
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//
//class MainActivity : ComponentActivity() {
//    @OptIn(DelicateCoroutinesApi::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // --- Simple Room Test ---
//        // Get a reference to the DAO
//        val taskDao = AppDatabase.getDatabase(applicationContext).taskDao()
//        // Example: Insert a task when a button is clicked or in onCreate
//        lifecycleScope.launch {
//            val testTask = Task(title = "Test Room Setup", description = "Verify database works!")
//            withContext(Dispatchers.IO) { // Perform database operations on a background thread
//                taskDao.insertTask(testTask)
//                Log.d("RoomTest", "Test task inserted!")
//            }
//
//            // Optional: Immediately query and log
//            val tasks = withContext(Dispatchers.IO) {
//                taskDao.getAllTasks().firstOrNull() // Assuming getAllTasks() returns a Flow or LiveData
//                // If it's a simple List, just call it.
//                // .firstOrNull() gets the first emission if it's a Flow
//            }
//            Log.d("RoomTest", "Retrieved tasks: $tasks")
//            if (tasks?.isNotEmpty() == true) {
//                Log.d("RoomTest", "First task title: ${tasks[0].title}")
//            } else {
//                Log.d("RoomTest", "No tasks found or Flow hasn't emitted yet.")
//            }
//        }
//
//
//        // Launch a coroutine to perform database operations (not on main thread)
//        // For a real app, use ViewModelScope or lifecycleScope
//        GlobalScope.launch(Dispatchers.IO) {
//            // Insert a new task
//            val testTask = Task(title = "Test Room Setup", description = "Check if DB ops work")
//            taskDao.insertTask(testTask)
//            Log.d("RoomTest", "Inserted Task: $testTask")
//
//            // Retrieve all tasks (using Flow, get the first emission for this simple test)
//            val allTasks = taskDao.getAllTasks().firstOrNull() // Collect first emission
//            Log.d("RoomTest", "All tasks after insert: $allTasks")
//
//            // Example: Update the task
//            allTasks?.firstOrNull()?.let { taskToUpdate ->
//                taskDao.updateTaskCompletion(taskToUpdate.id, true)
//                Log.d("RoomTest", "Updated task completion for ID: ${taskToUpdate.id}")
//
//                val updatedTask = taskDao.getTaskById(taskToUpdate.id)
//                Log.d("RoomTest", "Fetched updated task: $updatedTask")
//            }
//        }
//
//
//        setContent {
//            FocusFlowv1Theme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    // Display tasks for a slightly more visual test
//                    RoomTestScreen(taskDao = taskDao)
//                }
//            }
//        }
//    }
//}
//
//// A simple Composable to display tasks from the Flow
//@Composable
//fun RoomTestScreen(taskDao: TaskDao) {
//    val tasks by taskDao.getAllTasks().collectAsState(initial = emptyList())
//
//    // You can use a LaunchedEffect here as well if you need to perform one-off DB operations
//    // from a Composable, but generally, writes should be in a ViewModel or background coroutine.
//    // LaunchedEffect(Unit) {
//    //     taskDao.insertTask(Task(title = "Task from Composable", description = "Test"))
//    // }
//
//    if (tasks.isEmpty()) {
//        Text("No tasks yet. Check Logcat for DB operations.")
//    } else {
//        Text("Current tasks:\n${tasks.joinToString("\n") { it.title }}")
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FocusFlowv1Theme {
//        Text("Hello Android!") // Keep your original preview or adapt it
//    }
//}
//
//

package com.fatokifury.focus_flow_v1

// ... other imports
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.fatokifury.focus_flow_v1.ui.theme.FocusFlowv1Theme
import com.fatokifury.focus_flow_v1.ui.theme.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FocusFlowv1Theme { // Your app's theme
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen() // Call your new HomeScreen composable here
                }
            }
        }
    }
}
