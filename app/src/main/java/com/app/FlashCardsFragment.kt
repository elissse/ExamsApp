package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.databinding.FragmentAuthorizationBinding
import com.app.databinding.FragmentFlashCardsBinding
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.wajahatkarim3.easyflipview.EasyFlipView

class FlashCardsFragment : Fragment(R.layout.fragment_flash_cards) {
    private var binding: FragmentFlashCardsBinding? = null
    private var adapter: FlashCardAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFlashCardsBinding.bind(view)
         val subjectId = arguments?.getInt(ARG_ID) ?: -1
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

    private fun initAdapter(subjectId: Int) {
        binding?.run {
//            Snackbar.make(
//                root,
//                "subject: $subjectId",
//                Snackbar.LENGTH_SHORT
//            ).show()
            adapter = FlashCardAdapter(
                list = FlashCardRepository.flashCards.filter { it.subjectId == subjectId },
                glide = Glide.with(this@FlashCardsFragment),
                onClick = {
                    Snackbar.make(root, it.answer, Snackbar.LENGTH_LONG).show()
                    //val viewHolder = view?.let { it1 -> ViewHolder(it1) }
                }
            )
            rvFlashCard.adapter = adapter
            // rvFlashCard.layoutManager = LinearLayoutManager(requireContext())
            rvFlashCard.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            btnGoToBack.setOnClickListener{
                findNavController().navigate(
                    R.id.action_flashCardsFragment_to_flashCardFragment
                )
            }
        }
    }


}