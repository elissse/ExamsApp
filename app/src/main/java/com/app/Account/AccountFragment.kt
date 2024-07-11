package com.app.Account

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.app.Account.Autorization.AuthorizationFragment
import com.app.R
import com.app.databinding.FragmentAccountBinding

class AccountFragment : Fragment(R.layout.fragment_account) {
    private var binding: FragmentAccountBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAccountBinding.bind(view)
        init()
    }

    private fun init() {
        binding?.run {
            val sharedPref = context?.getSharedPreferences(AuthorizationFragment.USER_INFO, Context.MODE_PRIVATE)
            tvName.text = sharedPref?.getString(AuthorizationFragment.NAME, "")
            tvSurname.text = sharedPref?.getString(AuthorizationFragment.SURNAME, "")
            tvPatronymic.text = sharedPref?.getString(AuthorizationFragment.PATRONYMIC, "")
            tvGroup.text = sharedPref?.getString(AuthorizationFragment.GROUP, "")

            ibSettings.setOnClickListener() {
                findNavController().navigate(R.id.action_accountFragment_to_settingsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}