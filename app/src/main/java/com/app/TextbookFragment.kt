package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.app.databinding.FragmentTextbookBinding

class TextbookFragment : Fragment(R.layout.fragment_textbook) {
    private var binding: FragmentTextbookBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTextbookBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}