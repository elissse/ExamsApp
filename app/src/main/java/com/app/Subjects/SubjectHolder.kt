package com.app.Subjects

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.databinding.ItemSubjectsBinding
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


class SubjectHolder(
    private val binding: ItemSubjectsBinding,
    private val glide: RequestManager,
    private val onClick: (Subject) -> Unit,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    fun onBind(subject: Subject) {
        binding.run {
            tvName.text = subject.name

            glide
                //.load(person.url)
                //.error(R.drawable.img_not_found)
                //.placeholder(R.drawable.img_cat)
                //.apply(requestOptions)
                //.into(ivImage)

            root.setOnClickListener {
                onClick.invoke(subject)
            }
        }
    }

}