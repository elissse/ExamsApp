package com.app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.databinding.FragmentTextbookBinding
import com.bumptech.glide.Glide

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {
    private lateinit var textbookRepository: LikeRepository
    private var binding: FragmentTextbookBinding? = null
    private var subjectId: Int? = null
    private var adapter: LikeAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textbookRepository = LikeRepository
        binding = FragmentTextbookBinding.bind(view)
        subjectId = arguments?.getInt(SUBJECT_ID)
        LikeRepository.update()
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val SUBJECT_ID = "SUBJECT_ID"
        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(SUBJECT_ID, id)
            return bundle
        }
    }

    private fun initAdapter() {
        LikeRepository.update()
        binding?.run {
            adapter = LikeAdapter(
                list = textbookRepository.like,
                glide = Glide.with(this@FavoritesFragment),
            )
            binding?.rvTextbook?.adapter = adapter

            rvTextbook.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
