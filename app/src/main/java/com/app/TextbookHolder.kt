package com.app

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.databinding.FragmentTextbookBinding
import com.app.databinding.ItemTextbookBinding
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.security.AccessController.getContext


class TextbookHolder(
    private val binding: ItemTextbookBinding,
    private val glide: RequestManager,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    fun onBind(textbook: Textbook) {
        binding.run {
            tvTitleAndAuthor.text = textbook.titleAndAuthor
            tvUrl.text = textbook.url

            if (textbook.like) {
                btnLiked.visibility = View.VISIBLE
            } else {
                btnLiked.visibility = View.INVISIBLE
            }

            btnLike.setOnClickListener(View.OnClickListener { view ->
                btnLiked.visibility = View.VISIBLE
                textbook.like = !(textbook.like)
                TextbookRepository.getInstance(view.context).add()
            })

            btnLiked.setOnClickListener(View.OnClickListener { view ->
                btnLiked.visibility = View.INVISIBLE
                textbook.like = !(textbook.like)
                TextbookRepository.getInstance(view.context).add()
            })

            glide
                .load(textbook.photoUrl)
                .error(R.drawable.img_not_found)
                .placeholder(R.drawable.baseline_menu_book_24)
                .apply(requestOptions)
                .into(ivImage)
        }
    }
}