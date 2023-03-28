package com.yacahya.note_app_compose.feature.presentation.notes

import com.yacahya.note_app_compose.feature.domain.model.Note
import com.yacahya.note_app_compose.feature.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
