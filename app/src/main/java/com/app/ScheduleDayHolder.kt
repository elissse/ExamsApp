package com.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.databinding.ItemScheduleDayBinding
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class ScheduleDayHolder (
    private val binding: ItemScheduleDayBinding,
    private val glide: RequestManager,
    private val onClick: (ScheduleDay) -> Unit,
) : ViewHolder(binding.root) {
    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(scheduleDay: ScheduleDay) {

        binding.run {
            tvVinyl.text = scheduleDay.dayOfWeek
            tvSinger.text = scheduleDay.date.toString()

            root.setOnClickListener {
                onClick.invoke(scheduleDay)
            }
        }
    }
}