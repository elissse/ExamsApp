package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.app.databinding.FragmentSubjectBinding

class SubjectFragment : Fragment(R.layout.fragment_subject) {
    private var binding: FragmentSubjectBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubjectBinding.bind(view)
        binding?.run {
            tvTitle.setOnClickListener { veiw->
                veiw.findNavController().navigate(R.id.action_subjectFragment_to_flashCardFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}