package com.example.myshop.registration.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myshop.R
import com.example.myshop.databinding.FragmentDiscountBinding

class DiscountFragment : Fragment() {

    private lateinit var binding: FragmentDiscountBinding

    companion object {
        fun newInstance() = DiscountFragment()
    }

    private lateinit var viewModel: DiscountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDiscountBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiscountViewModel::class.java)
        // TODO: Use the ViewModel
    }

}