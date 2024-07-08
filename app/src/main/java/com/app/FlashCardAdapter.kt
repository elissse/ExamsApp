package com.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.app.databinding.ItemFlashCardBinding

class FlashCardAdapter(
    private var list: List<FlashCard>,
    private val glide: RequestManager,
    private val onClick: (FlashCard) -> Unit,
) : RecyclerView.Adapter<FlashCardHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlashCardHolder = FlashCardHolder(
        binding = ItemFlashCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun onBindViewHolder(holder: FlashCardHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
    fun updateDataset(newList : List<FlashCard>) {
        list = newList
        notifyDataSetChanged()
    }
}