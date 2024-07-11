package com.app.FlashCard

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson

object FlashCardSharedPreferences {
    private var sharedPreferences: SharedPreferences? = null
    fun init(context: Context) {
        sharedPreferences =
            context.getSharedPreferences("flashCardsSharedPrefs", Context.MODE_PRIVATE)
    }


    fun updateListOfFlashCards(id: String, flashCard: FlashCard) {
        val flashCardString = Gson().toJson(flashCard)
        with(sharedPreferences?.edit()) {
            this?.putString(id, flashCardString)
            Log.d("TAG1", "$id  $flashCardString")
            this?.apply()
        }
    }

    fun getListOfFlashCardsForSubject(subjectId: Int): MutableList<FlashCard> {
        // val type = object : TypeToken<FlashCard>() {}.type
        val list = mutableListOf<FlashCard>()
        var count = 1
        Log.d("TAG1", "ogod")
        while (true) {
            val json: String = sharedPreferences?.getString("$subjectId:${count}", "") ?: break
            Log.d("TAG2", json)
            count++
            val flashCard = Gson().fromJson(json, FlashCard::class.java)
            Log.d("TAG3", "good")
            when (flashCard) {
                null -> break
                else -> list.add(flashCard)
            }
        }
        return list
    }

    fun getSize(subjectId: Int): Int {
        var count = 0
        while (true) {
            count++
            val json: String = sharedPreferences?.getString("$subjectId:${count}", "") ?: break
            Log.d("TAG$", "counting $json $count")
            if (json == "") break
        }
        return count
    }
}