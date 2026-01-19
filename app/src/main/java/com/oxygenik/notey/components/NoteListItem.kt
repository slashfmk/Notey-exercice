package com.oxygenik.notey.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oxygenik.notey.roomdb.Note


@Composable
fun NoteListItem(note: Note) {
    Card(
        modifier = Modifier.padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(note.color))
                .padding(12.dp)
        ) {
            Text(
                text = "${note.title}",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "${note.description}",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun PreviewNoteListItem() {

    val note = Note(
        id = 0,
        title = "Sample note",
        description = "Note description sanple",
        125
    )

    NoteListItem(note = note)
}