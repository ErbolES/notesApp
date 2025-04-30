package com.example.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.notesapp.databinding.FragmentNoteEditBinding

class NoteEditFragment : Fragment() {
    private var noteId: Int = 0

    companion object {
        fun newInstance(noteId: Int): NoteEditFragment {
            val fragment = NoteEditFragment()
            val args = Bundle()
            args.putInt("note_id", noteId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        noteId = arguments?.getInt("note_id") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etTitle = view.findViewById<EditText>(R.id.etTitle)
        val etContent = view.findViewById<EditText>(R.id.etContent)

        // Загружаем данные заметки, если noteId != 0
        if (noteId != 0) {
            val note = NoteRepository.getNoteById(noteId)
            etTitle.setText(note?.title)
            etContent.setText(note?.content)
        }
    }
}
