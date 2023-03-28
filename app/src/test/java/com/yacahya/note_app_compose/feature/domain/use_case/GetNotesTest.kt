package com.yacahya.note_app_compose.feature.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.yacahya.note_app_compose.feature.data.repository.FakeNoteRepository
import com.yacahya.note_app_compose.feature.domain.model.Note
import com.yacahya.note_app_compose.feature.domain.util.NoteOrder
import com.yacahya.note_app_compose.feature.domain.util.OrderType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNotesTest {
    private lateinit var getNotes: GetNotes
    private lateinit var fakeNoteRepository: FakeNoteRepository

    @Before
    fun setUp() {
        fakeNoteRepository = FakeNoteRepository()
        getNotes = GetNotes(fakeNoteRepository)

        val notesToInsert = mutableListOf<Note>()
        ('a'..'z').forEachIndexed { index, c ->
            notesToInsert.add(
                Note(
                    title = c.toString(),
                    content = c.toString(),
                    timestamp = index.toLong(),
                    color = index
                )
            )
        }
        notesToInsert.shuffle()
        runBlocking {
            notesToInsert.forEach { fakeNoteRepository.insertNote(it) }
        }
    }

    @Test
    fun `Order note by title ascending, correct order`() = runBlocking {
        val notes = getNotes(NoteOrder.Title(OrderType.Ascending)).first()

        for (i in 0..notes.size - 2) {
            assertThat(notes[i].title).isLessThan(notes[i + 1].title)
        }
    }

    @Test
    fun `Order note by title descending, correct order`() = runBlocking {
        val notes = getNotes(NoteOrder.Title(OrderType.Descending)).first()

        for (i in 0..notes.size - 2) {
            assertThat(notes[i].title).isGreaterThan(notes[i + 1].title)
        }
    }

    @Test
    fun `Order note by date ascending, correct order`() = runBlocking {
        val notes = getNotes(NoteOrder.Date(OrderType.Ascending)).first()

        for (i in 0..notes.size - 2) {
            assertThat(notes[i].timestamp).isLessThan(notes[i + 1].timestamp)
        }
    }

    @Test
    fun `Order note by date descending, correct order`() = runBlocking {
        val notes = getNotes(NoteOrder.Date(OrderType.Descending)).first()

        for (i in 0..notes.size - 2) {
            assertThat(notes[i].timestamp).isGreaterThan(notes[i + 1].timestamp)
        }
    }

    @Test
    fun `Order note by color ascending, correct order`() = runBlocking {
        val notes = getNotes(NoteOrder.Color(OrderType.Ascending)).first()

        for (i in 0..notes.size - 2) {
            assertThat(notes[i].color).isLessThan(notes[i + 1].color)
        }
    }

    @Test
    fun `Order note by color descending, correct order`() = runBlocking {
        val notes = getNotes(NoteOrder.Color(OrderType.Descending)).first()

        for (i in 0..notes.size - 2) {
            assertThat(notes[i].color).isGreaterThan(notes[i + 1].color)
        }
    }
}