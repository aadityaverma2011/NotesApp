package com.now.kitt.feature_note.domain.use_case

import com.now.kitt.feature_note.domain.model.Note
import com.now.kitt.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id : Int): Note?{
        return repository.getNotebyId(id)
    }
}