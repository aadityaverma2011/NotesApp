package com.now.kitt.feature_note.domain.util

import com.now.kitt.feature_note.domain.model.Note

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote : NotesEvent()
    object TogglesOrderSection: NotesEvent()
}
