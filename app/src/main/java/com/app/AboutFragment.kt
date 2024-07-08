package com.app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.databinding.FragmentAboutBinding
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class AboutFragment: Fragment(R.layout.fragment_about) {
    var binding: FragmentAboutBinding? = null
    private var adapter: AboutAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutBinding.bind(view)
        init()
    }

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private fun init() {
        binding?.run {
            adapter = AboutAdapter(
                list = CreatorsRepository.creators
            )
            rvAbout.adapter = adapter
            rvAbout.layoutManager = LinearLayoutManager(requireContext())
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