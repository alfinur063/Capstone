package com.example.capstoneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.capstoneproject.databinding.ActivityMainBinding
import com.example.capstoneproject.view.MainViewModel
import com.example.capstoneproject.view.login.login

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSession().observe(this) { UserSession ->
            if (!UserSession.isLogin) {
                val intent = Intent(this, login::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}