package com.app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.databinding.FragmentSubjectBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class SubjectFragment : Fragment(R.layout.fragment_subject) {

    private var binding: FragmentSubjectBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubjectBinding.bind(view)
        val subjectId = arguments?.getInt(SUBJECT_ID)
        if (subjectId != null) {
            val subject = SubjectRepository.subjects.single {
                it.id == subjectId
            }
            setInfo(subject)
        }

        binding?.btnGoToBack?.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    private fun setInfo(subject: Subject) {
        binding?.run {
            //tvPersonId.text = "${getString(R.string.id)}${person.id}"
            tvSubjectName.text = "${subject.name}"

            tvInfotext.text = "${subject.info}"

//            Glide.with(this@SubjectFragment)
//                .load(person.url)
//                .placeholder(R.drawable.baseline_image_not_supported_24)
//                .error(R.drawable.baseline_error_outline_24)
//                .apply(options)
//                .into(icon)
        }
    }
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        private const val SUBJECT_ID = "SUBJECT_ID"

        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(SUBJECT_ID, id)
            return bundle
        }
    }

}