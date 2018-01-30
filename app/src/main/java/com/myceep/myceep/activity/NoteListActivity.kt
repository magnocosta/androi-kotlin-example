package com.myceep.myceep.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.myceep.myceep.R
import com.myceep.myceep.connector.repository.RepositoryProvider
import com.myceep.myceep.component.NoteListAdapter
import com.myceep.myceep.connector.NoteConnector
import com.myceep.myceep.helper.NoteResponse
import com.myceep.myceep.model.Note

import kotlinx.android.synthetic.main.activity_note_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoteListActivity : AppCompatActivity() {

    private val TAG = NoteListActivity::class.java.simpleName

    private val noteConnector = NoteConnector()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        noteConnector.list( object: NoteResponse{
            override fun sucess(notes: List<Note>) {
                configureList(notes);
            }
        })
    }

    private fun configureList(notes: List<Note>) {
        note_list_recycle_view.adapter = NoteListAdapter(notes, this)
        note_list_recycle_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

}
