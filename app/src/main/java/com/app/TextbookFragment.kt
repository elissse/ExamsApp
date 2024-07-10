package com.app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.databinding.FragmentTextbookBinding
import com.bumptech.glide.Glide

class TextbookFragment : Fragment(R.layout.fragment_textbook) {

    private lateinit var textbookRepository: LikeRepository
    private var binding: FragmentTextbookBinding? = null
    private var subjectId: Int? = null
    private var adapter: TextbookAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textbookRepository = LikeRepository
        binding = FragmentTextbookBinding.bind(view)
        subjectId = arguments?.getInt(ARG_ID)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {
        private const val ARG_ID = "ARG_ID"
        fun bundle(id: Int): Bundle = Bundle().apply {
            putInt(ARG_ID, id)
        }
    }

    private fun initAdapter() {
        binding?.run {
            adapter = TextbookAdapter(
                list = textbookRepository.textbooks.filter { textbook ->
                    textbook.idSubject == subjectId
                },
                glide = Glide.with(this@TextbookFragment),
            )
            binding?.rvTextbook?.adapter = adapter

            rvTextbook.layoutManager = LinearLayoutManager(requireContext())
        }
    }

}

