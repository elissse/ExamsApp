package com.app

object FlashCardRepository {

    val flashCards: MutableList<FlashCard> = mutableListOf(
        FlashCard(
            id = 1,
            subjectId = 1,
            question = "why1",
            answer = "because1"
        ),
        FlashCard(
            id = 2,
            subjectId = 1,
            question = "why2",
            answer = "because2"
        ),
        FlashCard(
            id = 3,
            subjectId = 2,
            question = "why3",
            answer = "because3"
        ),
        FlashCard(
            id = 4,
            subjectId = 1,
            question = "why4",
            answer = "because4"
        )
    )

}