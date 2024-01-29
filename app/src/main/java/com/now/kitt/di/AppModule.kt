package com.now.kitt.di

import android.app.Application
import androidx.room.Room
import com.now.kitt.feature_note.data.data_source.NoteDao
import com.now.kitt.feature_note.data.data_source.NoteDatabase
import com.now.kitt.feature_note.data.repository.NoteRepositoryImpl
import com.now.kitt.feature_note.domain.repository.NoteRepository
import com.now.kitt.feature_note.domain.use_case.AddNote
import com.now.kitt.feature_note.domain.use_case.DeleteNote
import com.now.kitt.feature_note.domain.use_case.GetNote
import com.now.kitt.feature_note.domain.use_case.GetNotes
import com.now.kitt.feature_note.domain.use_case.NotesUseCases
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            "NotesDB"
        ).build()
    }
    @Provides
    @Singleton
    fun provideNoteRespository(db : NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }
    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NotesUseCases{
        return NotesUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository),
        )
    }
}