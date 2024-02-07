package com.example.myshop.registration.presentation

import android.opengl.Visibility
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentActivity
import com.example.myshop.MainActivity
import com.example.myshop.R
import com.example.myshop.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {

    private val  KIRILLYC_PATTERN = "[а-яА-Я]{1,}".toRegex()

    private lateinit var binding: FragmentRegistrationBinding

    val loginButton by lazy {
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

        val  loginTextWatcher =  object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val firstname = binding.firstNameEditView.text.toString().trim()
                val lastname = binding.lastNameEditView.text.toString().trim()
                val number = binding.phoneEditView.text.toString()

                if (firstname.isNotEmpty() && lastname.isNotEmpty() && number.toString().isNotEmpty()){

                    binding.loginBtn.isEnabled = true}

            }
            override fun afterTextChanged(s: Editable?) {

            }
        }

        val firstNameValidator = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isEmpty()){
                    binding.firstNameEditViewLayout.error = context?.getText(R.string.input_firstname)
                    binding.firstNameEditViewLayout.isErrorEnabled = true
                }

               else if(!s.toString().matches(KIRILLYC_PATTERN)){
                    binding.firstNameEditViewLayout.error = context?.getText(R.string.valid_symbols)
                    binding.firstNameEditViewLayout.isErrorEnabled = true
                }

                else{binding.firstNameEditViewLayout.isErrorEnabled = false}
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }
        val lastNameValidator = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isEmpty()){
                    binding.lastNameEditViewLayout.error = context?.getText(R.string.input_lastname)
                    binding.lastNameEditViewLayout.isErrorEnabled = true
                }

                else if(!s.toString().matches(KIRILLYC_PATTERN)){
                    binding.lastNameEditViewLayout.error = context?.getText(R.string.valid_symbols)
                    binding.lastNameEditViewLayout.isErrorEnabled = true
                }

                else{binding.lastNameEditViewLayout.isErrorEnabled = false}
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }
        val phoneValidator = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isEmpty()){
                    binding.phoneEditViewLayout.error = context?.getText(R.string.input_phone)
                    binding.phoneEditViewLayout.isErrorEnabled = true
                }
                else{binding.phoneEditViewLayout.isErrorEnabled = false}
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }

        binding.firstNameEditView.addTextChangedListener (loginTextWatcher)
        binding.firstNameEditView.addTextChangedListener (firstNameValidator)
        binding.lastNameEditView.addTextChangedListener (loginTextWatcher)
        binding.lastNameEditView.addTextChangedListener (lastNameValidator)
        binding.phoneEditView.addTextChangedListener (loginTextWatcher)
        binding.phoneEditView.addTextChangedListener (phoneValidator)

        loginButton?.setOnClickListener {
            val scrollFragment = ScrollFragment.newInstance()
            parentFragmentManager.beginTransaction().replace(R.id.main_container, scrollFragment)
                .commit()
        }

    }

    companion object {


        fun newInstance() = RegistrationFragment()
    }
}