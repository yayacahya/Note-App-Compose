package com.yacahya.note_app_compose.feature.presentation.notes

import com.yacahya.note_app_compose.feature.domain.model.Note
import com.yacahya.note_app_compose.feature.domain.util.NoteOrder
import com.yacahya.note_app_compose.feature.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
