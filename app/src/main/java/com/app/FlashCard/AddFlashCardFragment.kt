package com.app.FlashCard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.R
import com.app.databinding.FragmentAddFlashCardBinding
import com.google.android.material.snackbar.Snackbar


class AddFlashCardFragment : Fragment(R.layout.fragment_add_flash_card) {
    private var binding: FragmentAddFlashCardBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddFlashCardBinding.bind(view)
        binding?.run {
            tvTitle.setOnClickListener {
                val question = questionEt.text.toString()
                val answer = answerEt.text.toString()
                val subjectId = arguments?.getInt(ARG_ID) ?: -1
                var size = FlashCardSharedPreferences.getSize(subjectId = subjectId)
                if (question.isNotEmpty() && answer.isNotEmpty()) {
                    val id = size
                    val flashCard = FlashCard(
                        id = id,
                        subjectId = subjectId,
                        question = question,
                        answer = answer
                    )
                    FlashCardSharedPreferences.updateListOfFlashCards("$subjectId:$id", flashCard)
                    //"$subjectId:$id"
                    findNavController().navigate(
                        R.id.action_addFlashCardFragment_to_flashCardFragment,
                        args = FlashCardFragment.bundle(
                            id = subjectId
                        )
                    )
                } else
                    Snackbar.make(
                        root,
                        "все поля должны быть непустыми",
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