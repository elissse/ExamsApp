package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.app.databinding.FragmentSubjectsBinding

class SubjectsFragment : Fragment(R.layout.fragment_subjects) {
    private var binding: FragmentSubjectsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubjectsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}