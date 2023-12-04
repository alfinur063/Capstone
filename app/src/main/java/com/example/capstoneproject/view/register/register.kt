package com.example.capstoneproject.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstoneproject.MainActivity
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ActivityRegisterBinding

class register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //regis to login page
        binding.goToLogin.setOnClickListener{
            startActivity(Intent(this@register, MainActivity::class.java))
        }

    }

    //create binding to connect register layout to login layout

    //this 2 must have to finish tomorrow

    //function to create account
    private fun setUpAction(){
        val username = null
        val email = null
        val password = null





    }

}