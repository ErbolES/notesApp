package com.example.notesapp

object NoteRepository {
    private val notes = mutableListOf(
        Note(0, "Первая заметка", "Это первая заметка"),
        Note(1, "Вторая заметка", "Это вторая заметка")
    )

    fun getNotes(): List<Note> = notes

    fun getNoteById(id: Int): Note? = notes.find { it.id == id }
}
