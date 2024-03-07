package com.example.myshop.registration.registration

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshop.R

class RegistrationViewModel : ViewModel() {
    private val KIRILLYC_PATTERN = "[а-яА-Я]{1,}".toRegex()

    val state = MutableLiveData<UiState>()

    fun updateFirstName(text : String) {
        val oldValue = state.value ?: UiState()

          val exception =   if (text.isEmpty()) {
                UiState.EmptyFieldException()
            } else if (!text.matches(KIRILLYC_PATTERN)) {
                UiState.InvalidSymbolException()
            } else {
               null
            }
        val newValue = oldValue.copy(firstName =  text, errorFirstName = exception)
       state.value = newValue.copy(loginBtnIsEnable = enableButton(newValue))
    }
    fun updateLastName(text : String){
        val oldValue = state.value?: UiState()

        val exception = if ( text.isEmpty() ){
            UiState.EmptyFieldException()
        }
        else if( !text.matches(KIRILLYC_PATTERN)){
            UiState.InvalidSymbolException()
        }
        else{ null}

        val newValue = oldValue.copy(lastName = text, errorLastName = exception)
        state.value = newValue.copy(loginBtnIsEnable = enableButton(newValue))

    }

    fun updatePhoneNumber (text: String){

        val oldValue = state.value?: UiState()

        val exception = if (text.isEmpty()){
            UiState.EmptyFieldException()
        }
        else {null }

        val newValue = oldValue.copy(phoneNumber = text, errorPhoneNumber = exception)

        state.value = newValue.copy(loginBtnIsEnable = enableButton(newValue))
    }

    private fun enableButton(state : UiState): Boolean{
        return state.firstName.isNotEmpty() && state.lastName.isNotEmpty() && state.phoneNumber.isNotEmpty()
                && state.errorFirstName == null && state.errorLastName ==null
                && state.errorPhoneNumber == null
    }
}