package com.yacahya.note_app_compose.feature.presentation.add_edit_note

sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String): AddEditNoteEvent()
    data class EnteredContent(val value: String): AddEditNoteEvent()
    data class ChangeColor(val color: Int): AddEditNoteEvent()
    object SaveNote: AddEditNoteEvent()
}
