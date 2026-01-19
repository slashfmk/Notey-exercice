package com.oxygenik.notey.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.oxygenik.notey.roomdb.Note
import com.oxygenik.notey.viewModels.NoteViewModel

@Composable
fun DisplayDialog(
    viewModel: NoteViewModel,
    showDialog: Boolean,
    onDismiss: () -> Unit
) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var color by remember { mutableStateOf(Color.Blue) }

    val colors = listOf<Color>(
        Color.Blue,
        Color.Green,
        Color.Cyan,
        Color.Red,
        Color.Magenta,
        Color.DarkGray,
        Color(0xFF664455),
        Color(0xFF662255),
        Color(0xFFCC22C9),
        Color(0xFF222255),
        Color(0xFF592295),
        Color(0xFF993354),

        )

    if (showDialog) {

        AlertDialog(
            onDismissRequest = { onDismiss() },
            dismissButton = {
                Button(onClick = { onDismiss() }) {
                    Text(text = "Cancel")
                }
            },
            title = { Text(text = "Enter a Note") },
            confirmButton = {
                Button(onClick = {

                    if (!title.isEmpty() && !description.isEmpty()) {
                        val note = Note(
                            title = title,
                            description = description,
                            color = color.toArgb()
                        )

                        viewModel.insert(note)
                        onDismiss()
                    }
                }) {
                    Text("Save Note")
                }
            },
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            text = {
                Column() {

                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text(text = "Title") }
                    )
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text(text = "Description") }
                    )

                    Spacer(modifier = Modifier.height(25.dp))

//                    TODOS - color pickers
                    ColorPickerComp(
                        setOfColors = colors,
                        selectedColor = color,
                        onColorSelected = {color = it}
                        )

                }
            }
        )
    }
}


//@Composable
//fun MyFloatingButton() {
//    FloatingActionButton(
//        onClick = { DisplayDialog() }
//    ) { }
//}


//@Preview(
//    showSystemUi = true
//)
//@Composable
//fun PreviewDisplayDialog() {
//    DisplayDialog(
//        showDialog = true,
//        onDismiss = { print("dismissed!") }
//    )
//}
