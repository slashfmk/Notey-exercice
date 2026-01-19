package com.oxygenik.notey.repository

import androidx.lifecycle.LiveData
import com.oxygenik.notey.roomdb.Note
import com.oxygenik.notey.roomdb.NoteDao

class NotesRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insertNote(note: Note) {
        return noteDao.insert(note)
    }
}