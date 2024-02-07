package com.example.myshop.domain.product
import  com.google.gson.annotations.SerializedName

data class Feedback(
    @SerializedName("count") val count: Int,
    @SerializedName("rating")val rating: Double
)