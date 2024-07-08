package com.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.databinding.ItemAboutUsBinding

class AboutAdapter(
    private var list: List<Creator>
): RecyclerView.Adapter<AboutHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AboutHolder = AboutHolder(
        binding = ItemAboutUsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AboutHolder, position: Int) {
        holder.onBind(list[position])
    }
}