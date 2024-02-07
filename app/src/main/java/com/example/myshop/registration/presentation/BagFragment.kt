package com.example.myshop.registration.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myshop.R
import com.example.myshop.databinding.FragmentBagBinding

class BagFragment : Fragment() {

    private lateinit var binding: FragmentBagBinding

    companion object {
        fun newInstance() = BagFragment()
    }

    private lateinit var viewModel: BagViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBagBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BagViewModel::class.java)
        // TODO: Use the ViewModel
    }

}