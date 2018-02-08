package com.myceep.myceep.connector

import android.util.Log
import com.myceep.myceep.connector.repository.NoteRepository
import com.myceep.myceep.connector.repository.RepositoryProvider
import com.myceep.myceep.helper.NoteResponse
import com.myceep.myceep.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoteConnector {

    val TAG = NoteConnector::class.java.simpleName;

    val noteRepository = RepositoryProvider().noteRepository()

    fun list(noteResponse: NoteResponse<List<Note>>) {
        noteRepository.list()
        noteResponse.sucess(notes());
    }

    fun create(note: Note, noteResponse: NoteResponse<Note>) {
        noteRepository.create(note)
        noteResponse.sucess(Note(note.title, note.description))
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