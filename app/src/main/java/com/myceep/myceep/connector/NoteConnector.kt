package com.myceep.myceep.connector

import com.myceep.myceep.model.Note
import retrofit2.Call
import retrofit2.http.GET

interface NoteConnector {

    @GET("notes")
    fun list() : Call<List<Note>>

}