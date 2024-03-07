package com.example.myshop.detail.images

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myshop.R

const val ARG_OBJECT = "object"
class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val value = arguments?.getInt(ARG_OBJECT)!!

        val imageView : ImageView = view.findViewById(R.id.image_view)
        imageView.setImageResource(value)

    }
    companion object {
        fun newInstance() = ImageFragment()
    }
}