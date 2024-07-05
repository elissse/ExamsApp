package com.app

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.app.databinding.ItemFlashCardBinding

class FlashCardHolder(
    private val binding: ItemFlashCardBinding,
    private val glide: RequestManager,
    private val onClick: (FlashCard) -> Unit,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(flashCard: FlashCard) {
        binding.run {
            tvQuestion.text = flashCard.question

            root.setOnClickListener {
                onClick.invoke(flashCard)
            }
        }
    }

//    private fun FlashCard.getTitleColor(): Int = if (url.length > 120) {
//        R.color.pink_700
//    } else {
//        R.color.pink_200
//    }
}