package com.app.Subjects

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.databinding.ItemSubjectsBinding
import com.bumptech.glide.RequestManager


class SubjectAdapter(
    private var list: List<Subject>,
    private val glide: RequestManager,
    private val onClick: (Subject) -> Unit,
) : RecyclerView.Adapter<SubjectHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectHolder = SubjectHolder(
        binding = ItemSubjectsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}