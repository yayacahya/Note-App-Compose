package com.yacahya.note_app_compose.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yacahya.note_app_compose.feature.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}