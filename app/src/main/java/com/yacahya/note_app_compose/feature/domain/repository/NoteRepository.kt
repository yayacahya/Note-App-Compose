package com.yacahya.note_app_compose.feature.domain.repository

import com.yacahya.note_app_compose.feature.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}