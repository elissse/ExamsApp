package com.app.Account.Settings.About

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.R
import com.app.databinding.ItemAboutUsBinding

class AboutHolder(
    private val binding: ItemAboutUsBinding
): ViewHolder(binding.root) {

    private val context: Context
        get() = itemView.context

    fun onBind(creator: Creator) {
        binding.run {
            tvName.text = creator.name
            tvDescription.text = creator.description
            val resourceId = context.resources.getIdentifier(creator.image, "drawable", context.packageName)
            when {
                resourceId != 0 -> ivImage.setImageResource(resourceId)
                else -> ivImage.setImageResource(R.drawable.baseline_person_light_gray_24)
            }
        }
    }
}