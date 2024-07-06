package com.app

import android.content.Context
import android.view.View
import androidx.compose.material3.Button
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.databinding.ItemTextbookBinding
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.util.stream.DoubleStream.Builder


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

            btnLike.setOnClickListener(View.OnClickListener {view ->
                btnLiked.visibility = View.VISIBLE
                LikeRepository.textbooks.add(textbook)
                textbook.like = !(textbook.like)
            })

            btnLiked.setOnClickListener(View.OnClickListener {view ->
                btnLiked.visibility = View.INVISIBLE
                LikeRepository.textbooks.remove(textbook)
                textbook.like = !(textbook.like)
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