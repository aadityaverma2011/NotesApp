package com.now.kitt.feature_note.presentation.notes

import com.now.kitt.feature_note.domain.model.Note
import com.now.kitt.feature_note.domain.util.NoteOrder
import com.now.kitt.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder= NoteOrder.Date(OrderType.Descending),
    val isOrdersectionVisible : Boolean = false
)
