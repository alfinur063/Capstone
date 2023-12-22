package com.example.capstoneproject.SplashScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.capstoneproject.R
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.databinding.ActivityWelcomeBinding
import com.example.capstoneproject.view.register.RegisterActivity
import com.example.capstoneproject.view.welcome.WelcomeActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    private val viewModel by viewModels<SplashScreenViewModel>{
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timeSplashScreen = 2000L

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, WelcomeActivity::class.java)
            viewModel.getSession().observe(this){
                    user ->
                if (!user.isLogin){
                    intent = Intent(this, RegisterActivity::class.java)
                }
            }
            startActivity(intent)
            finish()
        }, timeSplashScreen)
    }
}