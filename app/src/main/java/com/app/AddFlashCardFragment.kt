package com.app

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.privacysandbox.tools.core.model.Types
import com.app.databinding.FragmentAddFlashCardBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.Moshi
import java.lang.reflect.Type


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