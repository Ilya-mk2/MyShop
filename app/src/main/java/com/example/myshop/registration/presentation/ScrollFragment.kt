package com.example.myshop.registration.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myshop.R
import com.example.myshop.databinding.FragmentScrollBinding

class ScrollFragment : Fragment() {

    private lateinit var binding: FragmentScrollBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentScrollBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        replaceFragment(Home_Fragment.newInstance())

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bag -> replaceFragment(BagFragment.newInstance())
                R.id.profile -> replaceFragment(ProfileFragment.newInstance())
                R.id.discount -> replaceFragment(DiscountFragment.newInstance())
                R.id.home -> replaceFragment(Home_Fragment.newInstance())
                R.id.catalogue -> replaceFragment(CatalogueFragment.newInstance())
            }
            true
        }

    }

    private fun replaceFragment(f : Fragment){
        parentFragmentManager.beginTransaction().replace(R.id.scroll_fragment, f).commit()

    }
    companion object {

        fun newInstance() = ScrollFragment()

    }
}