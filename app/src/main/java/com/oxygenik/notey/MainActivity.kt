package com.oxygenik.notey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.oxygenik.notey.repository.NotesRepository
import com.oxygenik.notey.roomdb.NotesDB
import com.oxygenik.notey.screens.HomeScreen
import com.oxygenik.notey.ui.theme.NoteyTheme
import com.oxygenik.notey.viewModels.NoteViewModel
import com.oxygenik.notey.viewModels.NoteViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Db things
        val database = NotesDB.getInstance(applicationContext)
        // repository
        val repository = NotesRepository(database.notesDao)
        // viewModel factory
        val viewModelFactory = NoteViewModelFactory(repository)
        // ViewModel
        val noteViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[NoteViewModel::class.java]

        setContent {
            NoteyTheme {
                HomeScreen(noteViewModel = noteViewModel)
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteyTheme {
        Greeting("Android")
    }
}