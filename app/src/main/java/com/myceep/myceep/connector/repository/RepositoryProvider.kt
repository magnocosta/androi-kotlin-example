package com.myceep.myceep.connector.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryProvider {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.194:3000/notes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun noteRepository() : NoteRepository {
        return retrofit.create(NoteRepository::class.java)
    }

}