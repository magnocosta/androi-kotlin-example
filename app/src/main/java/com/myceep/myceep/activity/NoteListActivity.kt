package com.myceep.myceep.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myceep.myceep.R
import com.myceep.myceep.component.NoteListAdapter
import com.myceep.myceep.connector.NoteConnector
import com.myceep.myceep.helper.NoteResponse
import com.myceep.myceep.model.Note

import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.form_add_note.view.*

class NoteListActivity : AppCompatActivity() {

    private val TAG = NoteListActivity::class.java.simpleName

    private val noteConnector = NoteConnector()

    private val notes = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        initAndConfigureComponents()
    }

    private fun initAndConfigureComponents() {
        configureCreateNoteButton()
        initNoteListView()
    }

    private fun initNoteListView() {
        noteConnector.list( object: NoteResponse<List<Note>>{
            override fun sucess(notes: List<Note>) {
                this@NoteListActivity.notes.addAll(notes)
                configureList();
            }
        })
    }

    private fun configureList() {
        note_list_recycle_view.adapter = NoteListAdapter(notes, this)
        note_list_recycle_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    private fun configureCreateNoteButton() {
        btt_add_note.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?) {
                this@NoteListActivity.initCreateNote()
            }
        })
    }

    private fun initCreateNote() {
        val createNoteView = LayoutInflater
                .from(this)
                .inflate(R.layout.form_add_note, window.decorView as ViewGroup, false)

        AlertDialog.Builder(this)
                .setTitle("Add Note")
                .setView(createNoteView)
                .setPositiveButton("Salvar", object: DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, witch: Int) {
                        val title = createNoteView.title.text.toString()
                        val description = createNoteView.description.text.toString()
                        val note = Note(title, description)
                        noteConnector.create(note, object: NoteResponse<Note> {
                            override fun sucess(response: Note) {
                                notes.add(note)
                                configureList()
                            }
                        })
                    }
                })
                .show()
    }

}
