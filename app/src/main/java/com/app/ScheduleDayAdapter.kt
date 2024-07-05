package com.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.databinding.ItemScheduleDayBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.model.Model
import com.bumptech.glide.request.transition.Transition.ViewAdapter

class ScheduleDayAdapter (
    private var list: List<ScheduleDay>,
    private val glide: RequestManager,
    private val onClick: (ScheduleDay) -> Unit,
) : RecyclerView.Adapter<ScheduleDayHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScheduleDayHolder = ScheduleDayHolder(
        binding = ItemScheduleDayBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ScheduleDayHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun updateDataset(newList: List<ScheduleDay>) {
        list = newList
        notifyDataSetChanged()
    }
}