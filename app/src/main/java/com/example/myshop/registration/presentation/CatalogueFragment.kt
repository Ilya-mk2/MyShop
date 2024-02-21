package com.example.myshop.registration.presentation

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.RecyclerListener
import com.example.myshop.ProductsAdapter
import com.example.myshop.R
import com.example.myshop.databinding.FragmentCatalogueBinding
import com.example.myshop.domain.product.CatalogueResponse
import com.example.myshop.domain.product.ProductModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type

private const val TAG = "tag"
class CatalogueFragment : Fragment() {


    private lateinit var binding: FragmentCatalogueBinding

    companion object {
        fun newInstance() = CatalogueFragment()
    }

    private lateinit var viewModel: CatalogueViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogueBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatalogueViewModel::class.java)


        val buff = BufferedReader(InputStreamReader(this.activity?.assets?.open("ItemsAPI.json")))
        val str = buff.use { it.readText() }

        val gson = Gson()

        val product: CatalogueResponse = gson.fromJson(str, CatalogueResponse::class.java)

        val listOfProducts = product.items


        val adapter = ProductsAdapter(listOfProducts) { position ->

            val productFragment = ProductFragment.newInstance(listOfProducts[position])


            parentFragmentManager.beginTransaction()
                .replace(R.id.scroll_fragment, productFragment).commit()

        }
        val recyclerView = binding.recyclerView

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter


    }



}