package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.app.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment(R.layout.fragment_authorization) {
    private var binding: FragmentAuthorizationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthorizationBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}