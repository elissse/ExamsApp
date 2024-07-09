package com.app

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.databinding.FragmentSubjectBinding
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class SubjectFragment : Fragment(R.layout.fragment_subject) {

    private var binding: FragmentSubjectBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubjectBinding.bind(view)
        val subjectId = arguments?.getInt(ARG_ID) ?: -1
        val subject = SubjectRepository.subjects.single {
            it.id == subjectId
        }
        setInfo(subject)


        binding?.btnGoToBack?.setOnClickListener {
            findNavController().navigate(R.id.action_subjectFragment_to_subjectsFragment)
        }

        binding?.materials?.setOnClickListener {
            findNavController().navigate(
                R.id.action_subjectFragment_to_textbookFragment,
                args = TextbookFragment.bundle(
                    id = subjectId
                )
            )
        }

        binding?.flashCards?.setOnClickListener {
            findNavController().navigate(
                R.id.action_subjectFragment_to_flashCardFragment,
                args = FlashCardFragment.bundle(
                    id = subjectId
                )
            )
        }

    }

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    private fun setInfo(subject: Subject) {
        binding?.run {
            tvSubjectName.text = "${subject.name}"
            tvInfotext.text = "${subject.info}"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        private const val ARG_ID = "ARG_ID"
        fun bundle(id: Int): Bundle = Bundle().apply {
            putInt(ARG_ID, id)
        }
    }
//    companion object {
//        private const val SUBJECT_ID = "SUBJECT_ID"
//        fun createBundle(id: Int): Bundle {
//            val bundle = Bundle()
//            bundle.putInt(SUBJECT_ID, id)
//            return bundle
//        }
//    }

}