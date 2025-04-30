package com.example.notesapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val notes = NoteRepository.getNotes()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = NoteAdapter(notes) { note ->
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NoteEditFragment.newInstance(note.id))
                .addToBackStack(null)
                .commit()
            binding.fragmentContainer.visibility = View.VISIBLE
            binding.rvNotes.visibility = View.GONE
        }

        binding.rvNotes.layoutManager = LinearLayoutManager(this)
        binding.rvNotes.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_edit_note) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NoteEditFragment.newInstance(0))
                .addToBackStack(null)
                .commit()
            binding.fragmentContainer.visibility = View.VISIBLE
            binding.rvNotes.visibility = View.GONE
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    
}
