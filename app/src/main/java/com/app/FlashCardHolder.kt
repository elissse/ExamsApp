package com.app

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.app.databinding.ItemFlashCardBinding
import com.wajahatkarim3.easyflipview.EasyFlipView

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
            frontSide.tvQuestion.text = flashCard.question
            backSide.tvAnswer.text = flashCard.answer
            backSide.mcBackSide.setOnClickListener {
                flipView.flipDuration = 1000
                flipView.flipTheView()
            }
            frontSide.mcFrontSide.setOnClickListener {
                flipView.flipDuration = 1000
                flipView.flipTheView()
            }
            root.setOnClickListener {
                onClick.invoke(flashCard)
            }
        }
    }
    inner class ViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {
        private val backSide: ConstraintLayout = view.findViewById(R.id.backSide)
        private val frontSide: ConstraintLayout = view.findViewById(R.id.frontSide)
        private val flipView: EasyFlipView = view.findViewById(R.id.flipView)

        init {
            backSide.setOnClickListener {
                flipView.flipDuration = 1000
                flipView.flipTheView()
            }
            frontSide.setOnClickListener {
                flipView.flipDuration = 1000
                flipView.flipTheView()
            }
        }
    }

//    private fun FlashCard.getTitleColor(): Int = if (url.length > 120) {
//        R.color.pink_700
//    } else {
//        R.color.pink_200
//    }
}