package com.example.capstoneproject.view.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.viewModels
import com.example.capstoneproject.MainActivity
import com.example.capstoneproject.R
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.database.preference.UserModel
import com.example.capstoneproject.database.repository.ResultState
import com.example.capstoneproject.databinding.ActivityLoginBinding
import com.example.capstoneproject.view.register.register

class login : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var inputEmail : String
    private lateinit var inputPassword : String

    private val viewModel by viewModels<LoginViewModel>{
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goToRegis.setOnClickListener {
            startActivity(Intent(this@login, register::class.java))
        }

        binding.submitButtonLogin.setOnClickListener(this)

        playAnimation()
    }

    private fun loginUser(){
        inputEmail = binding.emailEditText.text.toString()
        inputPassword = binding.passwordEditText.text.toString()

        viewModel.login(inputEmail, inputPassword).observe(this) { result ->
            if (result != null){
                when(result) {
                    is ResultState.Success -> {
                        binding.submitButtonLogin.isEnabled = true
                        viewModel.saveSession(
                            UserModel(
                                result.data.loginResult.name,
                                result.data.loginResult.token,
                            )
                        )

                        val intent = Intent(this@login, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()
                    }
                    is ResultState.Error -> {
                        binding.submitButtonLogin.isEnabled = true
                        Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
                    }
                    is ResultState.Loading -> {
                        binding.submitButtonLogin.isEnabled = false
                    }
                }
            }
        }
    }

    private fun playAnimation(){
        ObjectAnimator.ofFloat(binding.logo, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.welcomeText, View.ALPHA, 1f).setDuration(300)
        val desc = ObjectAnimator.ofFloat(binding.descText, View.ALPHA, 1f).setDuration(300)
        val emailText = ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(300)
        val emailEdtText = ObjectAnimator.ofFloat(binding.emailEditText, View.ALPHA, 1f).setDuration(300)
        val passText = ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(300)
        val passEdtText = ObjectAnimator.ofFloat(binding.passwordEditText, View.ALPHA, 1f).setDuration(300)
        val btnLogin = ObjectAnimator.ofFloat(binding.submitButtonLogin, View.ALPHA, 1f).setDuration(300)
        val textRegis = ObjectAnimator.ofFloat(binding.wantToRegis, View.ALPHA, 1f).setDuration(300)
        val moveRegis = ObjectAnimator.ofFloat(binding.goToRegis, View.ALPHA, 1f).setDuration(300)

        AnimatorSet().apply {
            playSequentially(
                title,
                desc,
                emailText,
                emailEdtText,
                passText,
                passEdtText,
                btnLogin,
                textRegis,
                moveRegis
            )
            startDelay = 100
        }.start()
    }

    override fun onClick(v: View?){
        when(v){
            binding.submitButtonLogin -> {
                loginUser()
            }
        }
    }
}