package com.example.capstoneproject.view.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.viewModels
import com.example.capstoneproject.MainActivity
import com.example.capstoneproject.R
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.database.api.ApiConfig
import com.example.capstoneproject.database.api.ApiService
//import com.example.capstoneproject.database.preference.Constant
//import com.example.capstoneproject.database.preference.PrefHelper
import com.example.capstoneproject.database.preference.UserModel
import com.example.capstoneproject.database.preference.UserPreference
import com.example.capstoneproject.database.preference.dataStore
import com.example.capstoneproject.database.repository.ResultState
import com.example.capstoneproject.databinding.ActivityLoginBinding
import com.example.capstoneproject.view.register.RegisterActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class LoginActivity : AppCompatActivity(), OnClickListener {

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

        supportActionBar?.hide()

        binding.goToRegis.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
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
                        showLoading(false)
//                        viewModel.saveSession(
//                            result.data.accessToken.
//                        )



                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()
                    }

                    is ResultState.Error -> {
                        showLoading(false)
                        binding.submitButtonLogin.isEnabled = true
                        Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
                    }

                    is ResultState.Loading -> {
                        binding.submitButtonLogin.isEnabled = false
                        showLoading(true)
                    }
                }
            }
        }
    }


    private fun showLoading(state: Boolean) {
        if (state) {
            binding.loadingState.visibility = View.VISIBLE
        } else {
            binding.loadingState.visibility = View.GONE
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
