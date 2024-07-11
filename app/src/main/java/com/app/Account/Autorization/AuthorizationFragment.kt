package com.app.Account.Autorization

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.R
import com.app.databinding.FragmentAuthorizationBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class AuthorizationFragment : Fragment(R.layout.fragment_authorization) {
    private var binding: FragmentAuthorizationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthorizationBinding.bind(view)
        init()
    }

    private fun init() {
        val sharedPref = context?.getSharedPreferences(USER_INFO, Context.MODE_PRIVATE)
        if (sharedPref?.getBoolean(CHANGED, false) == true) {
            findNavController().navigate(R.id.action_authorizationFragment_to_scheduleFragment)
        }
        binding?.run {
            doOnTextChangedSNP(et = etName, til = tilName, string = NAME)
            doOnTextChangedSNP(et = etSurname, til = tilSurname, string = SURNAME)
            doOnTextChangedSNP(et = etPatronymic, til = tilPatronymic, string = PATRONYMIC)
            doOnTextChangedGroup(et = etGroup, til = tilGroup)

            btn.setOnClickListener() {
                val name = etName.text?.toString()
                val surname = etSurname.text?.toString()
                val patronymic = etPatronymic.text?.toString()
                val group = etGroup.text?.toString()

                when {
                    isValidInfo(
                        tilName = tilName,
                        tilSurname = tilSurname,
                        tilPatronymic = tilPatronymic,
                        tilGroup = tilGroup
                    ) -> {
                        val editor = sharedPref?.edit()
                        editor?.putString(NAME, name)
                        editor?.putString(SURNAME, surname)
                        editor?.putString(PATRONYMIC, patronymic ?: "")
                        editor?.putString(GROUP, group)
                        editor?.putBoolean(CHANGED, true)
                        editor?.apply()
                        GroupRepository.curGroup = GROUP
                        findNavController().navigate(R.id.action_authorizationFragment_to_scheduleFragment)
                    }
                    else ->  Snackbar.make(root, "Invalid info, please try again", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun doOnTextChangedSNP(et: TextInputEditText, til: TextInputLayout, string: String) {
        val regex = Regex("[А-Я][а-я]*-*[А-Я]*[а-я]*")
        et.doOnTextChanged() { text, _, _, _ ->
            val str = text?.toString() ?: ""
            val title = string.lowercase()
            val message = when {
                str.isEmpty() && string.equals(PATRONYMIC) -> null
                str.isBlank() -> "Enter your $title"
                str[0] != text.toString()[0].uppercaseChar() -> "${string[0]}${title.substring(1)} must start with a capital letter"
                !regex.matches(str) -> "Make sure $title contains only letters and -"
                else -> null
            }
            til.error = message
        }
    }

    private fun doOnTextChangedGroup(et: TextInputEditText, til: TextInputLayout) {
        et.doOnTextChanged() { text, _, _ , _  ->
            val message = when {
                !GroupRepository.groups.contains(text.toString()) -> "Enter existing group"
                else -> null
            }
            til.error = message
        }
    }

    companion object {
        const val USER_INFO = "USER_INFO"
        const val NAME = "NAME"
        const val SURNAME = "SURNAME"
        const val PATRONYMIC = "PATRONYMIC"
        const val GROUP = "GROUP"
        const val CHANGED = "CHANGED"

        fun isValidInfo(tilName: TextInputLayout,
                                tilSurname: TextInputLayout,
                                tilPatronymic: TextInputLayout,
                                tilGroup: TextInputLayout)
                : Boolean = (tilName.error == null) &&
                (tilSurname.error == null) &&
                (tilPatronymic.error == null) &&
                (tilGroup.error == null)
    }
}