package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.app.databinding.FragmentAccountBinding

class AccountFragment : Fragment(R.layout.fragment_account) {
    private var name: String? = null
    private var surname: String? = null
    private var patronymic: String? = null
    private var group: String? = null
    private var binding: FragmentAccountBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAccountBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}