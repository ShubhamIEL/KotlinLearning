package com.example.greeterappjava

import android.R.attr.label
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // No more setContentView(R.layout.activity_main)!
        // setContent hosts our Jetpack Compose UI.
        setContent {
            // We call our main Composable function here.
            GreeterScreen()
        }
    }
}

@Composable
fun GreeterScreen(){

    var name by remember { mutableStateOf("") }
    var greetingText by remember { mutableStateOf("") }

    Column( modifier = Modifier.fillMaxSize()
        .padding(24.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = "YOur Name",
            onValueChange = {
                label = { Text("Enter Your Name")}
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {}) {
            Text("Greet Me")
        }

        Spacer( modifier = Modifier.height(32.dp))

        Text(text = "Hello , Mentor!")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreeterScreen()
}