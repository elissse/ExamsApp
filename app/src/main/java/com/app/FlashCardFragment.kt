package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.app.databinding.FragmentFlashCardBinding

class FlashCardFragment : Fragment(R.layout.fragment_flash_card) {
    private var binding: FragmentFlashCardBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFlashCardBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}