package com.app

object LikeRepository {
    var textbooks: MutableSet<Textbook> = mutableSetOf()

    var textbooks2: List<Textbook> = listOf()

    fun returnList() : List<Textbook> {
        return textbooks.toList()
    }
}