package com.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.databinding.FragmentAccountBinding
import com.app.databinding.FragmentScheduleBinding
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {
    private var binding: FragmentScheduleBinding? = null
    private var adapter: DayAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScheduleBinding.bind(view)
        DayRepository.changeToFollowing("11-305")

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = DayAdapter(
                list = DayRepository.days,
                onClick = {
                    findNavController().navigate(
                        R.id.action_scheduleFragment_to_subjectsFragment
                    )
                }
            )
            rvScheduleDay.adapter = adapter
            rvScheduleDay.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}