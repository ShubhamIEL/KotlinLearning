package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
//import com.example.myapplication.feature_profile.HistoryAdapter
import com.example.myapplication.feature_profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.nio.file.WatchEvent
import androidx.compose.runtime.livedata.observeAsState

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val profileViewModel: ProfileViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
  //  private lateinit var historyAdapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Find the ComposeView and set its content
        binding.userNameComposeView.setContent {
            // This is the bridge between ViewModel state and Compose UI
            val userName by profileViewModel.userName.collectAsStateWithLifecycle()

            // Call our new Composable function
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting(name = userName)
                Spacer(modifier = Modifier.height(16.dp))
                SimpleCounter()
            }
            binding.historyComposeView.setContent {
                val history by profileViewModel.history.observeAsState(initial = emptyList())
                HistoryList(historyItems = history)
            }
        }

        // Setup RecyclerView
//        historyAdapter = HistoryAdapter() //use lazy column to replace this
//        binding.historyRecyclerView.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = historyAdapter
//        }

        // Observe history LiveData //Lazy column replace this
//        profileViewModel.history.observe(this) { historyList ->
//            historyAdapter.submitList(historyList)
//        }

        // Setup Button Listener
        binding.updateNameButton.setOnClickListener {
            val name = binding.nameInput.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            profileViewModel.updateUserWithDelay(name)
        }
    }
}

// Your first Composable function
@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello, $name!",
        fontSize = 24.sp
    )
}
@Composable
fun SimpleCounter() {
    // 1. Create a state variable for the count.
    //    'remember' saves the state across recompositions.
    //    'by' delegate syntax makes it easy to get/set the value.
    var count by remember { mutableStateOf (0) }

    Button(onClick = { count++ }) { // 2. Modify the state on click
        Text("You have clicked me $count times") // 3. Read the state to display it
    }
}

@Composable
fun HistoryItem(itemText: String){
    Card (
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ){
        Text(
            text = itemText,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun HistoryList(historyItems: List<String>){
    LazyColumn {
        items(historyItems){
            item->HistoryItem(itemText = item)
        }
    }
}