package com.yacahya.note_app_compose.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yacahya.note_app_compose.feature.presentation.ui.theme.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)