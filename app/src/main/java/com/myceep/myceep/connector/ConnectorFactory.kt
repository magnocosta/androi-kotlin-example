package com.myceep.myceep.connector

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConnectorFactory {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.194:3000/notes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun noteConnector() : NoteConnector {
        return retrofit.create(NoteConnector::class.java)
    }

}