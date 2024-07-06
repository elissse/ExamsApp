package com.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.databinding.ItemDayBinding

class DayAdapter(
    private val list: List<Day>,
    private val onClick: (Day) -> Unit
) : RecyclerView.Adapter<DayHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DayHolder = DayHolder(
        binding = ItemDayBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onClick = onClick
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DayHolder, position: Int) {
        holder.onBind(list[position])
    }
}