package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.app.databinding.FragmentSubjectsBinding

class SubjectsFragment : Fragment(R.layout.fragment_subjects) {
    private var binding: FragmentSubjectsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubjectsBinding.bind(view)
        binding?.run {
            tvTitle.setOnClickListener { veiw->
                veiw.findNavController().navigate(R.id.action_subjectsFragment_to_subjectFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}