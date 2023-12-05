package com.example.capstoneproject.view.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ActivityLoginBinding

class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var inputEmail : String
    private lateinit var inputPassword : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}