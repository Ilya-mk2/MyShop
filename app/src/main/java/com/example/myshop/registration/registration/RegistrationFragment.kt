package com.example.myshop.registration.registration

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myshop.R
import com.example.myshop.databinding.FragmentRegistrationBinding
import com.example.myshop.registration.presentation.ScrollFragment
import ru.tinkoff.decoro.MaskDescriptor
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.DescriptorFormatWatcher
import ru.tinkoff.decoro.watchers.FormatWatcher


class RegistrationFragment : Fragment() {

    lateinit var binding: FragmentRegistrationBinding
    private val regModel : RegistrationViewModel by viewModels()

    private val loginButton by lazy {
        view?.findViewById<Button>(R.id.login_btn)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.isEnabled = false

        val maskDescriptor = MaskDescriptor.ofSlots(PredefinedSlots.RUS_PHONE_NUMBER)
        val watcher: FormatWatcher = DescriptorFormatWatcher(maskDescriptor)
        watcher.installOn(binding.phoneEditView)


        val firstNameValidator = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                regModel.updateFirstName(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {
            }
        }
        val lastNameValidator = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               regModel.updateLastName(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }
        val phoneValidator = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               regModel.updatePhoneNumber(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
        binding.firstNameEditView.addTextChangedListener(firstNameValidator)
        binding.lastNameEditView.addTextChangedListener(lastNameValidator)
        binding.phoneEditView.addTextChangedListener(phoneValidator)

        loginButton?.setOnClickListener {
            val scrollFragment = ScrollFragment.newInstance()
            parentFragmentManager.beginTransaction().replace(R.id.main_container, scrollFragment)
                .commit()
        }

        regModel.state.observe( viewLifecycleOwner) {
            if (it.errorFirstName is UiState.InvalidSymbolException) {
                binding.firstNameEditViewLayout.error = context?.getText(R.string.valid_symbols)
                binding.firstNameEditViewLayout.isErrorEnabled = true
            } else if (it.errorFirstName is UiState.EmptyFieldException) {
                binding.firstNameEditViewLayout.error = context?.getText(R.string.input_firstname)
                binding.firstNameEditViewLayout.isErrorEnabled = true
            } else {
                binding.firstNameEditViewLayout.isErrorEnabled = false
            }
            if (it.errorLastName is UiState.InvalidSymbolException){
                binding.lastNameEditViewLayout.error = context?.getText(R.string.valid_symbols)
                binding.lastNameEditViewLayout.isErrorEnabled = true
            }
            else if (it.errorLastName is UiState.EmptyFieldException){
                binding.lastNameEditViewLayout.error = context?.getText(R.string.input_lastname)
                binding.lastNameEditViewLayout.isErrorEnabled = true
            }
            else{
                binding.lastNameEditViewLayout.isErrorEnabled = false
            }

            if (it.errorPhoneNumber is UiState.EmptyFieldException){
                binding.phoneEditViewLayout.error = context?.getText(R.string.input_phone)
            }
            else{
                binding.phoneEditViewLayout.isErrorEnabled = false
            }


            loginButton?.isEnabled = it.loginBtnIsEnable
        }

    }
    companion object {
        fun newInstance() = RegistrationFragment()
    }
}