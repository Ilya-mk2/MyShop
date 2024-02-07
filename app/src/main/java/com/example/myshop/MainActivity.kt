package com.example.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myshop.registration.presentation.RegistrationFragment
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registrationFragment = RegistrationFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, registrationFragment)
            .commit()



    }
}