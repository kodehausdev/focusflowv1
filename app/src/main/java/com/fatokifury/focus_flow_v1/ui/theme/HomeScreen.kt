//package com.fatokifury.focus_flow_v1.ui.theme // Or your chosen package
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.fatokifury.focus_flow_v1.R // Make sure this matches YOUR package name
//
//@Composable
//fun HomeScreen() {
//    val schoolName = "Focus Flow Academy"
//    val principalName = "Dr. Evelyn Reed"
//    val welcomeMessage = "Welcome Students Back to School!"
//    val students = listOf(
//        "Alice Wonderland", "Bob The Builder", "Charlie Brown",
//        "Diana Prince", "Edward Scissorhands"
//    )
//
//    // THIS IS THE MAIN VERTICAL ORGANIZER
//    Column(
//        modifier = Modifier
//            .fillMaxSize() // Takes up the whole screen
//            .background(MaterialTheme.colorScheme.background)
//            .padding(16.dp)
//            .verticalScroll(rememberScrollState()), // << ADD THIS TO ALLOW SCROLLING IF CONTENT OVERFLOWS
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // 1. School Logo (IF YOU HAVE ONE AND IT'S CORRECTLY REFERENCED)
//        // Ensure R.drawable.ic_school_logo exists and is valid!
//        Image(
//            painter = painterResource(id = R.drawable.ic_school_logo),
//            contentDescription = "School Logo",
//            modifier = Modifier
//                .size(100.dp)
//                .padding(bottom = 16.dp),
//            contentScale = ContentScale.Fit
//        )
//
//        // 2. School Name
//        Text(
//            text = schoolName,
//            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
//            color = MaterialTheme.colorScheme.primary,
//            textAlign = TextAlign.Center
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // 3. Welcome Message
//        Text(
//            text = welcomeMessage,
//            style = MaterialTheme.typography.titleLarge,
//            color = MaterialTheme.colorScheme.secondary,
//            textAlign = TextAlign.Center
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // 4. Principal Info Card
//        PrincipalInfoCard(principalName = principalName)
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        // 5. "Our Amazing Students" Title
//        Text(
//            text = "Our Amazing Students:",
//            style = MaterialTheme.typography.titleMedium,
//            modifier = Modifier.align(Alignment.Start) // Aligns this specific Text to the start
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // 6. Student List
//        StudentList(students = students)
//
//        // Add some extra space at the bottom if needed, especially with scrolling
//        Spacer(modifier = Modifier.height(16.dp))
//    }
//}
//
//
//@Composable
//fun PrincipalInfoCard(principalName: String) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Principal's Office",
//                style = MaterialTheme.typography.titleSmall,
//                color = MaterialTheme.colorScheme.onSurfaceVariant
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = principalName,
//                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
//                color = MaterialTheme.colorScheme.onSurfaceVariant
//            )
//        }
//    }
//}
//
//@Composable
//fun StudentList(students: List<String>) {
//    if (students.isEmpty()) {
//        Text("No students to display yet.")
//    } else {
//        // Using LazyColumn for potentially long lists (efficient)
//        LazyColumn(
//            modifier = Modifier.fillMaxWidth(),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            items(students) { studentName ->
//                StudentRow(studentName = studentName)
//            }
//        }
//    }
//}
//@Composable
//fun StudentRow(studentName: String) {
//    Text(
//        text = "- $studentName",
//        style = MaterialTheme.typography.bodyMedium,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 8.dp)
//    )
//}
//
//// Preview Composable
//@Preview(showBackground = true, name = "HomeScreen Preview")
//@Composable
//fun DefaultPreviewHomeScreen() {
//    FocusFlowv1Theme { // Apply your app's theme for the preview
//        HomeScreen()
//    }
//}
//
//@Preview(showBackground = true, name = "HomeScreen Dark Preview")
//@Composable
//fun DarkPreviewHomeScreen() {
//    FocusFlowv1Theme(darkTheme = true) { // Apply your app's theme for the preview
//        HomeScreen()
//    }
//}
//
//
//


package com.fatokifury.focus_flow_v1.ui.theme // Or your chosen package

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn // Keep this
import androidx.compose.foundation.lazy.items     // Keep this
// REMOVE: import androidx.compose.foundation.rememberScrollState
// REMOVE: import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fatokifury.focus_flow_v1.R // Make sure this matches YOUR package name

@Composable
fun HomeScreen() {
    val schoolName = "Focus Flow Academy"
    val principalName = "Dr. Evelyn Reed"
    val welcomeMessage = "Welcome Students Back to School!"
    val students = listOf(
        "Alice Wonderland", "Bob The Builder", "Charlie Brown",
        "Diana Prince", "Edward Scissorhands"
    )

    // LazyColumn is now the MAIN ORGANIZER and SCROLLER
    LazyColumn(
        modifier = Modifier
            .fillMaxSize() // Takes up the whole screen
            .background(MaterialTheme.colorScheme.background),
        // Apply padding to the content within the LazyColumn, not the LazyColumn itself if background needs to fill edges
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Children items will be centered by default
    ) {
        // Item 1: School Logo
        item {
            Image(
                painter = painterResource(id = R.drawable.ic_school_logo),
                contentDescription = "School Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp), // Space below this item
                contentScale = ContentScale.Fit
            )
        }

        // Item 2: School Name
        item {
            Text(
                text = schoolName,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth() // To allow TextAlign.Center to work across the width
            )
            Spacer(modifier = Modifier.height(8.dp)) // Spacer after this item
        }

        // Item 3: Welcome Message
        item {
            Text(
                text = welcomeMessage,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Item 4: Principal Info Card
        item {
            PrincipalInfoCard(principalName = principalName)
            Spacer(modifier = Modifier.height(24.dp))
        }

        // Item 5: "Our Amazing Students" Title
        item {
            Text(
                text = "Our Amazing Students:",
                style = MaterialTheme.typography.titleMedium,
                // To align this text to the start, ensure its container (the item)
                // allows for it, or the text component itself aligns if it fills width.
                // Since LazyColumn's horizontalAlignment is CenterHorizontally,
                // if this Text doesn't fill width, it will be centered.
                // To make it appear at the start:
                modifier = Modifier
                    .fillMaxWidth() // Let the item take full width
                    .padding(start = 0.dp), // Effectively align left within the centered block
                textAlign = TextAlign.Start // Align text content to the start
            )
            // An alternative if you want it strictly at the screen edge, ignoring LazyColumn's center:
            // Column(modifier = Modifier.fillMaxWidth()) {
            //     Text(
            //         text = "Our Amazing Students:",
            //         style = MaterialTheme.typography.titleMedium,
            //         modifier = Modifier.align(Alignment.Start)
            //      )
            // }
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Item 6: Student List (integrated)
        if (students.isEmpty()) {
            item {
                Text(
                    text = "No students to display yet.",
                    modifier = Modifier.padding(vertical = 8.dp) // Add some padding
                )
            }
        } else {
            items(students) { studentName ->
                StudentRow(studentName = studentName)
            }
        }

        // Add some extra space at the bottom if needed
        item {
            Spacer(modifier = Modifier.height(16.dp)) // This will be the last item, ensuring scroll space
        }
    }
}

// PrincipalInfoCard remains the same
@Composable
fun PrincipalInfoCard(principalName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), // Padding for the card itself, if needed outside its content
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp) // Padding inside the card
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Principal's Office",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = principalName,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// StudentList composable is no longer needed as its logic is merged into HomeScreen's LazyColumn
// You can delete this composable.

// StudentRow remains the same
@Composable
fun StudentRow(studentName: String) {
    Text(
        text = "- $studentName",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .fillMaxWidth() // Makes the text row take full width
            .padding(start = 8.dp) // Indent the student name
    )
}

// Preview Composable - Ensure it still works or update if needed
@Preview(showBackground = true, name = "HomeScreen Preview")
@Composable
fun DefaultPreviewHomeScreen() {
    FocusFlowv1Theme { // Apply your app's theme for the preview
        HomeScreen()
    }
}

@Preview(showBackground = true, name = "HomeScreen Dark Preview")
@Composable
fun DarkPreviewHomeScreen() {
    FocusFlowv1Theme(darkTheme = true) { // Apply your app's theme for the preview
        HomeScreen()
    }
}


