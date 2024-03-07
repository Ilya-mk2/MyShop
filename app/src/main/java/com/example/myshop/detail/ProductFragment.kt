package com.example.myshop.detail

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.example.myshop.R
import com.example.myshop.databinding.FragmentProductBinding
import com.example.myshop.domain.product.ProductModel
import com.example.myshop.detail.images.ImageAdapter
import com.example.myshop.detail.images.ImageFragment
import com.google.android.material.tabs.TabLayoutMediator

class ProductFragment : Fragment() {
    private lateinit var adapter : ImageAdapter
    private lateinit var viewPager : ViewPager2
    private lateinit var imageFragment: ImageFragment

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

        adapter = ImageAdapter( images.getValue(productModel.id), this  )
        viewPager = binding.viewPager
        viewPager.adapter =adapter

        TabLayoutMediator(binding.swipeViews, viewPager) { tab, position ->

        }.attach()

    }
    companion object {

        val images = mapOf(
            "cbf0c984-7c6c-4ada-82da-e29dc698bb50" to listOf(R.drawable.img1, R.drawable.img2),
            "54a876a5-2205-48ba-9498-cfecff4baa6e" to listOf(R.drawable.img3, R.drawable.img4),
            "75c84407-52e1-4cce-a73a-ff2d3ac031b3" to listOf(R.drawable.img5, R.drawable.img6),
            "16f88865-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.img7, R.drawable.img8),
            "26f88856-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.img9, R.drawable.img10),
            "15f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.img11, R.drawable.img12),
            "88f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.img13, R.drawable.img14),
            "55f58865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.img15, R.drawable.img16)
        )


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