package com.oxygenik.notey.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.oxygenik.notey.roomdb.Note

@Composable
fun DisplayNotesList(notes: List<Note>) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(notes) { note ->
            NoteListItem(note = note)
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun PreviewDisplayNotesList() {

    val notes = listOf<Note>(
        Note(id = 0, title = "Note 1", description = "short descr", color = "#ff6600".toColorInt()),
        Note(id = 1, title = "Note 2", description = "medium descr", color = "#224466".toColorInt()),
        Note(id = 2, title = "Note 3", description = "long descr", color = "#bb4567".toColorInt()),
        Note(id = 4, title = "Note 4", description = "long descr", color = "#662255".toColorInt())
        )

    DisplayNotesList(notes)
}