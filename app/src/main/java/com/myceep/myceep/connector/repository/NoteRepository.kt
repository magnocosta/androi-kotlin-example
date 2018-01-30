package com.myceep.myceep.connector.repository

import com.myceep.myceep.model.Note
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface NoteRepository {

    @GET("notes")
    fun list() : Call<List<Note>>

    @POST("notes")
    fun create(note: Note) : Call<Note>

}