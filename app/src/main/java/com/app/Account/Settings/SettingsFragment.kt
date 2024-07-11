package com.app.Account.Settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.app.R
import com.app.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        init()
    }

    private fun init() {
        binding?.run {
            ibBack.setOnClickListener() {
                findNavController().navigateUp()
            }
            mbChangeProfile.setOnClickListener() {
                findNavController().navigate(R.id.action_settingsFragment_to_changeSettingsFragment)
            }
            mbSupport.setOnClickListener() {
                findNavController().navigate(R.id.action_settingsFragment_to_supportFragment)
            }
            mbAbout.setOnClickListener() {
                findNavController().navigate(R.id.action_settingsFragment_to_aboutFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}