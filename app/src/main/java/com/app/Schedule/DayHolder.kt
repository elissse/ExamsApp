package com.app.Schedule

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.databinding.ItemDayBinding

class DayHolder(
    private val binding: ItemDayBinding,
    private val onClick: (Day) -> Unit,
) : ViewHolder(binding.root) {

    fun onBind(day: Day) {
        binding.run {
            tvDayOfWeek.text = day.ofWeek
            tvDay.text = day.number.toString()
            tvSubject.text = day.subject

            root.setOnClickListener {
                onClick.invoke(day)
            }
        }
    }
}