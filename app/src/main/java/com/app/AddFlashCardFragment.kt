package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.app.databinding.FragmentAddFlashCardBinding


class AddFlashCardFragment : Fragment(R.layout.fragment_add_flash_card) {
    private var binding: FragmentAddFlashCardBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddFlashCardBinding.bind(view)
        binding?.run {
            tvTitle.setOnClickListener {
                val question = questionEt.text.toString()
                val answer = answerEt.text.toString()
                var size = FlashCardRepository.flashCards.size

                if (question.isNotEmpty()) {
                    val subjectId = arguments?.getInt(ARG_ID) ?: -1
                    FlashCardRepository.flashCards.add(
                        FlashCard(
                            id = ++size,
                            subjectId = subjectId,
                            question = question,
                            answer = answer
                        )
                    )
                    findNavController().navigate(
                        R.id.action_addFlashCardFragment_to_flashCardFragment,
                        args = FlashCardsFragment.bundle(
                            id = subjectId
                        )
                    )
                } else
                    Snackbar.make(
                        root,
                        "all the fields need to be NOT empty",
                        Snackbar.LENGTH_SHORT
                    ).show()
            }
        }
    }

    companion object {
        private const val ARG_ID = "ARG_ID"
        fun bundle(id: Int): Bundle = Bundle().apply {
            putInt(ARG_ID, id)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}