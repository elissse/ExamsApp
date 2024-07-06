package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.databinding.FragmentAuthorizationBinding
import com.app.databinding.FragmentFlashCardBinding
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class FlashCardFragment : Fragment(R.layout.fragment_flash_card) {
    private var binding: FragmentFlashCardBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFlashCardBinding.bind(view)
        //val subjectId = arguments?.getInt(ARG_ID) ?: -1
        val subjectId = 1
        binding?.run {
            mcvFlashCards.setOnClickListener {
                findNavController().navigate(
                    R.id.action_flashCardFragment_to_flashCardsFragment,
                    args = FlashCardsFragment.bundle(
                        id = subjectId
                    )
                )
            }
            mcvButton.setOnClickListener {

                findNavController().navigate(
                    R.id.action_flashCardFragment_to_addFlashCardFragment,
                    args = AddFlashCardFragment.bundle(
                        id = subjectId
                    )
                )
            }

        }
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
//    companion object {
//        private const val ARG_QUESTION = "ARG_QUESTION"
//        private const val ARG_ANSWER = "ARG_ANSWER"
//        fun bundle(question: String, answer: String): Bundle = Bundle().apply {
//            putString(ARG_QUESTION, question)
//            putString(ARG_ANSWER, answer)
//        }
//    }
}