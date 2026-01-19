package com.oxygenik.notey.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.oxygenik.notey.components.DisplayDialog
import com.oxygenik.notey.components.DisplayNotesList
import com.oxygenik.notey.viewModels.NoteViewModel


@Composable
fun HomeScreen(noteViewModel: NoteViewModel) {

    var showModal by remember { mutableStateOf(false) }

    val notes by noteViewModel.allNotes.observeAsState(emptyList())

    Box() {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            DisplayNotesList(notes = notes)

            DisplayDialog(
                viewModel = noteViewModel,
                showDialog = showModal,
                onDismiss = { showModal = false }
            )
        }

        Button(onClick = { showModal = !showModal }) {
            Text(text = "Add new Note")
        }

    }


}
