package com.myceep.myceep.helper

import com.myceep.myceep.model.Note

interface NoteResponse {

    fun sucess(notes: List<Note>)
}