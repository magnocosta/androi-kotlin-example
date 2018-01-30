package com.myceep.myceep.connector

import android.util.Log
import com.myceep.myceep.connector.repository.RepositoryProvider
import com.myceep.myceep.helper.NoteResponse
import com.myceep.myceep.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoteConnector {

    val TAG = NoteConnector::class.java.simpleName;

    val noteRepository = RepositoryProvider().noteRepository()

    fun list(noteResponse: NoteResponse) {
        val call = noteRepository.list()
        noteResponse.sucess(notes());
        /*call.enqueue(object: Callback<List<Note>> {
            override fun onResponse(call: Call<List<Note>>?, response: Response<List<Note>>?) {
                response?.body()?.let {
                    noteResponse.sucess(it)
                }
                Log.i(TAG, "Response receive with success")
            }

            override fun onFailure(call: Call<List<Note>>?, t: Throwable?) {
                Log.e(TAG, "Failed on receive response", t)
            }
        })*/

    }

    fun create(note: Note) {

    }

    private fun notes() : List<Note> {
        return arrayListOf(
                Note("Livro de JSF", "Descricao sobre o livro"),
                Note("Livro de Java", "Descricao sobre o livro"),
                Note("Livro de Ruby on Rails", "Descricao sobre o livro"),
                Note("Livro de Docker", "Descricao sobre o livro"),
                Note("Livro de Go", "Descricao sobre o livro")
        )
    }

}