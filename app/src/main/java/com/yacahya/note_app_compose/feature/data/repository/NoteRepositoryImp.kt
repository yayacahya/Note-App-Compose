package com.yacahya.note_app_compose.feature.data.repository

import com.yacahya.note_app_compose.feature.data.data_source.NoteDao
import com.yacahya.note_app_compose.feature.domain.model.Note
import com.yacahya.note_app_compose.feature.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImp(
    private val dao: NoteDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}