package com.example.myshop.registration.presentation

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.myshop.R
import com.example.myshop.databinding.FragmentProductBinding
import com.example.myshop.domain.product.ProductModel

class ProductFragment : Fragment() {
     lateinit var binding: FragmentProductBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        val productModel = arguments?.getSerializable(TAG) as ProductModel

        binding.titleTv.text = productModel.title
        binding.subtitleTv.text = productModel.subtitle
        binding.priceTv.text = productModel.price.price
        binding.discountPriceTv.text = productModel.price.priceWithDiscount
        binding.availableTv.text = productModel.available.toString()
        binding.descriptionTv.text = productModel.description
    }
    companion object {
       const val TAG = "tag"
        fun newInstance(product : ProductModel?=null) : ProductFragment {

            val fragment = ProductFragment()
            val arguments = Bundle()
            arguments.putSerializable(TAG, product)
            fragment.arguments = arguments
            return fragment

        }
    }

}