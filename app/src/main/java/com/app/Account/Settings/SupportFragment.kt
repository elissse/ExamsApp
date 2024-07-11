package com.app.Account.Settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.R
import com.app.databinding.FragmentSupportBinding

class SupportFragment: Fragment(R.layout.fragment_support) {
    var binding: FragmentSupportBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSupportBinding.bind(view)
        init()
    }

    private fun init() {
        binding?.run {
            ibBack.setOnClickListener() {
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}