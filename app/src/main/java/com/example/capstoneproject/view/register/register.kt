package com.example.capstoneproject.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.capstoneproject.MainActivity
import com.example.capstoneproject.R
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.database.repository.ResultState
import com.example.capstoneproject.databinding.ActivityRegisterBinding
import com.example.capstoneproject.view.login.login

class register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<RegisterViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //regis to login page
        binding.goToLogin.setOnClickListener{
            startActivity(Intent(this@register, login::class.java))
        }
        binding.button.setOnClickListener {
            setUpAction()
        }

    }

    //create binding to connect register layout to login layout

    //this 2 must have to finish tomorrow

    //function to create account
    private fun setUpAction() {
        val username = binding.edRegisterName.text.toString()
        val email = binding.edEmail.text.toString()
        val password = binding.edPassword.text.toString()

        viewModel.register(username, email, password).observe(this) { result ->
            if (result != null) {
                when (result) {
                    is ResultState.Loading -> {
                    binding.button.isEnabled = false
                    }
                    is ResultState.Success -> {
                        Toast.makeText(this, "Congrats, you have been created an acount", Toast.LENGTH_SHORT).show()
                        binding.button.isEnabled = true
                        val intent = Intent(this@register, login::class.java)
                        startActivity(intent)
                    }
                    is ResultState.Error -> {
                        Toast.makeText(this, "your registet is failed", Toast.LENGTH_SHORT).show()
                        binding.button.isEnabled = true
                    }
                }
            }
        }

    }
}