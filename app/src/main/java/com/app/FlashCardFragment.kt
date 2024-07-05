package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.databinding.FragmentAuthorizationBinding
import com.app.databinding.FragmentFlashCardBinding
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class FlashCardFragment : Fragment(R.layout.fragment_flash_card) {
    private var binding: FragmentFlashCardBinding? = null
    private var adapter: FlashCardAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFlashCardBinding.bind(view)
       // val subjectId = arguments?.getInt(ARG_ID) ?: "ERROR"
        val subjectId = 1
        val flashCards = FlashCardRepository.flashCards.filter { it.subjectId == subjectId }
        initAdapter(subjectId)
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
    private fun initAdapter(subjectId:Int) {
        binding?.run {
            adapter = FlashCardAdapter(
                list = FlashCardRepository.flashCards.filter { it.subjectId == subjectId },
                glide = Glide.with(this@FlashCardFragment),
                onClick = {
                    Snackbar.make(root, it.answer, Snackbar.LENGTH_LONG).show()
                }
            )
            rvFlashCard.adapter = adapter
           // rvFlashCard.layoutManager = LinearLayoutManager(requireContext())
            rvFlashCard.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }
}