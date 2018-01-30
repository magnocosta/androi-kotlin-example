package com.myceep.myceep.helper

import com.myceep.myceep.model.Note

interface NoteResponse<T> {

    fun sucess(response: T)
}