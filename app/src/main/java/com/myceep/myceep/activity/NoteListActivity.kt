package com.myceep.myceep.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.myceep.myceep.R
import com.myceep.myceep.component.NoteListAdapter
import com.myceep.myceep.model.Note

import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        initRecycleView()
    }

    private fun initRecycleView() {
        note_list_recycle_view.adapter = NoteListAdapter(notes(), this)
        note_list_recycle_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    private fun notes() : List<Note> {
        return arrayListOf(
                Note("teste A", "oi"),
                Note("teste B", "oi"),
                Note("teste C", "oi"),
                Note("teste D", "oi"),
                Note("teste E", "oi")
        )
    }

}
