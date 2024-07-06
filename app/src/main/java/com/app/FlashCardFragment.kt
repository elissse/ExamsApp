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
        val subjectId = arguments?.getInt(SUBJECT_ID) ?: -1
        //val subjectId = 1
        binding?.run {
            mcvFlashCards.setOnClickListener {
                Snackbar.make(
                    root,
                    "subject: $subjectId",
                    Snackbar.LENGTH_SHORT
                ).show()
                findNavController().navigate(
                    R.id.action_flashCardFragment_to_flashCardsFragment,
                    FlashCardsFragment.createBundle(subjectId!!)
                )
            }
            mcvButton.setOnClickListener {
                Snackbar.make(
                    root,
                    "subject: $subjectId",
                    Snackbar.LENGTH_SHORT
                ).show()
                findNavController().navigate(
                    R.id.action_flashCardFragment_to_addFlashCardFragment,
                    AddFlashCardFragment.createBundle(subjectId!!)
                )
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
//    companion object {
//        private const val ARG_ID = "ARG_ID"
//        fun bundle(id: Int): Bundle = Bundle().apply {
//            putInt(ARG_ID, id)
//        }
//    }
    companion object {

        private const val SUBJECT_ID = "SUBJECT_ID"
        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(SUBJECT_ID, id)
            return bundle
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