package com.app

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.text.util.Linkify
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.databinding.ItemTextbookBinding
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


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

            val originalText = tvUrl.text.toString()
            val spannableBuilder = SpannableStringBuilder(originalText)
            Linkify.addLinks(spannableBuilder, Linkify.WEB_URLS)
            tvUrl.text = spannableBuilder
            tvUrl.movementMethod = LinkMovementMethod.getInstance()


            if (textbook.like) {
                btnLiked.visibility = View.VISIBLE
            }
            else {
                btnLiked.visibility = View.INVISIBLE
            }

            btnLike.setOnClickListener(View.OnClickListener {view ->
                btnLiked.visibility = View.VISIBLE
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