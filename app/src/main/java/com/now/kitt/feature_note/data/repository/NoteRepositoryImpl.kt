package com.now.kitt.feature_note.data.repository

import com.now.kitt.feature_note.data.data_source.NoteDao
import com.now.kitt.feature_note.domain.model.Note
import com.now.kitt.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNotebyId(id: Int): Note? {
       return dao.getNotesbyId(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}