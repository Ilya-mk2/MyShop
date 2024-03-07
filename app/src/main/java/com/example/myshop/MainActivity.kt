package com.example.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myshop.registration.registration.RegistrationFragment

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