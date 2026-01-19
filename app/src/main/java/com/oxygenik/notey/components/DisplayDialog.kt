package com.oxygenik.notey.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

    var colors = listOf<Color>(
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
                        var note = Note(
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


                    LazyRow(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        items(colors) { clr ->
                            Box(
                                modifier = Modifier
                                    .size(25.dp)
                                    .clip(CircleShape)
                                    .background(clr)
                                    .border(
                                        width = if (clr == color) 3.dp else 0.dp,
                                        shape = CircleShape,
                                        color = if (clr == color) Color.White else Color.Transparent
                                    )
                                    .clickable(
                                        onClick = { color = clr }
                                    )
                            ) {
//                            Text(text = clr.toString())
                            }
                        }

                    }

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
