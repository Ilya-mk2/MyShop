package com.example.myshop.registration.registration

import android.widget.Button

data class UiState (
    val firstName:String="",
    val lastName : String="",
    val phoneNumber: String="",
    val loginBtnIsEnable : Boolean = false,
    val errorFirstName : Exception?=null,
    val errorLastName : Exception?=null,
    val errorPhoneNumber : Exception?=null
    ){



    class InvalidSymbolException() : Exception()

    class EmptyFieldException() : Exception()
}