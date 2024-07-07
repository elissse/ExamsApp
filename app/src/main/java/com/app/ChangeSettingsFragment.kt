package com.app

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.AuthorizationFragment.Companion.GROUP
import com.app.AuthorizationFragment.Companion.NAME
import com.app.AuthorizationFragment.Companion.PATRONYMIC
import com.app.AuthorizationFragment.Companion.SURNAME
import com.app.AuthorizationFragment.Companion.isValidInfo
import com.app.databinding.FragmentChangeSettingsBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ChangeSettingsFragment: Fragment(R.layout.fragment_change_settings) {
    var binding: FragmentChangeSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChangeSettingsBinding.bind(view)
        init()
    }

    private fun init() {
        binding?.run {
            ibBack.setOnClickListener() {
                findNavController().navigate(R.id.action_changeSettingsFragment_to_settingsFragment2)
            }

            val sharedPref = context?.getSharedPreferences(AuthorizationFragment.USER_INFO, Context.MODE_PRIVATE)
            tilName.hint = sharedPref?.getString(NAME, "")
            tilSurname.hint = sharedPref?.getString(SURNAME, "")
            tilPatronymic.hint = sharedPref?.getString(PATRONYMIC, "")
            tilGroup.hint = sharedPref?.getString(GROUP, "")

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
                        editor?.putString(NAME, if (name?.isEmpty() == true) tilName.hint.toString() else name)
                        editor?.putString(SURNAME, if (surname?.isEmpty() == true) tilSurname.hint.toString() else surname)
                        editor?.putString(PATRONYMIC, if (patronymic?.isEmpty() == true) tilPatronymic.hint.toString() else patronymic)
                        editor?.putString(GROUP, if (group?.isEmpty() == true) tilGroup.hint.toString() else group)
                        editor?.apply()
                        Snackbar.make(root, "Your profile has been successfully changed", Snackbar.LENGTH_SHORT).show()
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
            val title = "${string[0]}${string.substring(1).lowercase()}"
            val message = when {
                str.isEmpty() -> null
                str.isBlank() -> "Enter your $title"
                str[0] != text.toString()[0].uppercaseChar() -> "$title must start with a capital letter"
                !regex.matches(str) -> "Make sure $title contains only letters and -"
                else -> null
            }
            til.error = message
        }
    }

    private fun doOnTextChangedGroup(et: TextInputEditText, til: TextInputLayout) {
        et.doOnTextChanged() { text, _, _ , _  ->
            val message = when {
                text?.isEmpty() == true -> null
                !GroupRepository.groups.contains(text.toString()) -> "Enter existing group"
                else -> null
            }
            til.error = message
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}