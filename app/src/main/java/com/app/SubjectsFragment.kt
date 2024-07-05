package com.app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.app.databinding.FragmentSubjectsBinding
//import ru.itis.summerpractice.utils.showSnackbar

class SubjectsFragment : Fragment(R.layout.fragment_subjects) {

    private var binding: FragmentSubjectsBinding? = null

    private var adapter: SubjectAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubjectsBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = SubjectAdapter(
                list = SubjectRepository.subjects,
                glide = Glide.with(this@SubjectsFragment),
                onClick = { subject ->
                    findNavController().navigate(
                        R.id.action_subjectsFragment_to_subjectFragment,
                        SubjectFragment.createBundle(subject.id)
                    )
                    //binding?.root?.showSnackbar(subject.name)
                }

            )

            binding?.rvSubjects?.adapter = adapter

//          по-умолчанию линерлайоутманагер строит вертикальный список
            rvSubjects.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}