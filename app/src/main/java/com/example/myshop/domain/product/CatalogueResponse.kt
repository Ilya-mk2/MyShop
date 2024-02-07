package com.example.myshop.domain.product

import com.google.gson.annotations.SerializedName

data class CatalogueResponse (
    @SerializedName("items") val items : ArrayList<ProductModel>){
}