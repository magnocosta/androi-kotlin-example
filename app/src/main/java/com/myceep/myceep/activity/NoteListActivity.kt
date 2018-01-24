package com.myceep.myceep.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.myceep.myceep.R
import com.myceep.myceep.connector.ConnectorFactory
import com.myceep.myceep.component.NoteListAdapter
import com.myceep.myceep.model.Note

import kotlinx.android.synthetic.main.activity_note_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoteListActivity : AppCompatActivity() {

    private val TAG = NoteListActivity::class.java.simpleName

    private val noteConnector = ConnectorFactory().noteConnector()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val call = noteConnector.list()
        call.enqueue(object: Callback<List<Note>?> {
            override fun onResponse(call: Call<List<Note>?>?, response: Response<List<Note>?>?) {
                response?.body()?.let {
                    val notes = it
                    configureList(notes)
                }
            }

            override fun onFailure(call: Call<List<Note>?>?, t: Throwable?) {
                Log.e(TAG, "Não foi possivel comunicar com o servidor", t)
                configureList(notes())
            }
        })
    }

    private fun configureList(notes: List<Note>) {
        note_list_recycle_view.adapter = NoteListAdapter(notes, this)
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
