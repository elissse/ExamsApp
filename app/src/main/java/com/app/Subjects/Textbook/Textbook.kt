package com.app.Subjects.Textbook

data class Textbook (
    val idSubject: Int,
    val idTextbook: Int,
    val titleAndAuthor: String,
    val photoUrl: String,
    val url: String,
    var like: Boolean
)
