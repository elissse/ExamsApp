package com.app.Subjects.Textbook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.databinding.ItemTextbookBinding
import com.bumptech.glide.RequestManager


class TextbookAdapter(
    private var list: List<Textbook>,
    private val glide: RequestManager,
    ) : RecyclerView.Adapter<TextbookHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TextbookHolder = TextbookHolder(
        binding = ItemTextbookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
    )

    override fun onBindViewHolder(holder: TextbookHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}