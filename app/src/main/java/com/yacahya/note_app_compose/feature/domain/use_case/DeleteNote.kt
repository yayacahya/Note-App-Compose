package com.yacahya.note_app_compose.feature.domain.use_case

import com.yacahya.note_app_compose.feature.domain.model.Note
import com.yacahya.note_app_compose.feature.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}