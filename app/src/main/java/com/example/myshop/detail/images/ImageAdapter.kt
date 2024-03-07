package com.example.myshop.detail.images

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ImageAdapter(private val list : List<Int>, fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment {

        val fragment = ImageFragment.newInstance()

        val bundle = Bundle()

        bundle.putInt(ARG_OBJECT, list.get(position))

        fragment.arguments = bundle

        return fragment
    }

}