package com.app.Subjects.Textbook

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.R
import com.app.Subjects.SubjectFragment
import com.app.databinding.FragmentTextbookBinding
import com.bumptech.glide.Glide

class TextbookFragment : Fragment(R.layout.fragment_textbook) {

    private lateinit var textbookRepository: TextbookRepository
    private var binding: FragmentTextbookBinding? = null
    private var subjectId: Int? = null
    private var adapter: TextbookAdapter? = null
    private lateinit var sharedPref: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textbookRepository = TextbookRepository.getInstance(requireContext())
        binding = FragmentTextbookBinding.bind(view)
        subjectId = arguments?.getInt(ARG_ID)

        sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)!!
        initAdapter()

//        binding?.btnGoToBacksubject?.setOnClickListener {
//            findNavController().navigate(
//                R.id.action_textbookFragment_to_subjectFragment,
//                args = SubjectFragment.bundle(
//                    id = subjectId!!
//                )
//            )
//        }
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
