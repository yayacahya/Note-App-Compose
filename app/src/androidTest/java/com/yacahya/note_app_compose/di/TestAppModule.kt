package com.yacahya.note_app_compose.di

import android.app.Application
import androidx.room.Room
import com.yacahya.note_app_compose.feature.data.data_source.NoteDao
import com.yacahya.note_app_compose.feature.data.data_source.NoteDatabase
import com.yacahya.note_app_compose.feature.data.repository.NoteRepositoryImp
import com.yacahya.note_app_compose.feature.domain.repository.NoteRepository
import com.yacahya.note_app_compose.feature.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            NoteDatabase::class.java,
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImp(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}