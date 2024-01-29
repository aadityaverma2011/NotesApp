package com.now.kitt.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity("note")
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey
    val noteId: Int?= null

){
    companion object{
        val notecolors= listOf(Color.Red,Color.Cyan,Color.Green,Color.Yellow,Color.LightGray)
    }
}


class InvalidNoteException(message: String): Exception(message)
