
package com.fatokifury.focus_flow_v1.ui.theme // Or your chosen package

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.fatokifury.focus_flow_v1.R

@Composable
fun HomeScreen() {
    val schoolName = "Focus Flow Academy"
    val principalName = "Dr. Evelyn Reed"
    val welcomeMessage = "Welcome Students Back to School!"
    val students = listOf(
        "Alice Wonderland", "Bob The Builder", "Charlie Brown",
        "Diana Prince", "Edward Scissorhands"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
         Apply padding to the content within the LazyColumn, not the LazyColumn itself if background needs to fill edges
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Children items will be centered by default
    ) {
        // Item 1: School Logo
        item {
            Image(
                painter = painterResource(id = R.drawable.ic_school_logo),
                contentDescription = "School Logo",
                modifier = Modifier
                    .size(190.dp)
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

                modifier = Modifier
                    .fillMaxWidth() // Let the item take full width
                    .padding(start = 0.dp),
                textAlign = TextAlign.Start
            )

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


