package com.example.capstoneproject.view.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.capstoneproject.MainActivity
import com.example.capstoneproject.database.api.ApiConfig
import com.example.capstoneproject.database.preference.Constant
import com.example.capstoneproject.database.preference.PrefHelper
import com.example.capstoneproject.databinding.ActivityLoginBinding
import com.example.capstoneproject.view.register.RegisterActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var inputEmail: String
    private lateinit var inputPassword: String

    lateinit var prefHelper: PrefHelper

//    private val viewModel by viewModels<LoginViewModel> {
//        ViewModelFactory.getInstance(this)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefHelper = PrefHelper(this)

        binding.goToRegis.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }


        binding.submitButtonLogin.setOnClickListener{
            login()
        }


        playAnimation()
    }

    fun login() {
        if (binding.emailEditText.text!!.isEmpty()){
            binding.emailEditText.error = "kolom Email tidak boleh kosong"
            binding.emailEditText.requestFocus()
            return
        }else if (binding.passwordEditText.text!!.isEmpty()){
            binding.passwordEditText.error = "kolom password tidak boleh kosong"
            binding.passwordEditText.requestFocus()
            return
        }

        ApiConfig.instanceRetrofit.login(binding.emailEditText.text.toString(), binding.passwordEditText.text.toString()).enqueue(object : Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response != null) {
                    saveSession(binding.emailEditText.text.toString(),binding.passwordEditText.text.toString())
                    Toast.makeText(
                        this@LoginActivity,
                        "Congrats, you have been created an acount",
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.submitButtonLogin.isEnabled = true
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    val i = Intent(this@LoginActivity, MainActivity::class.java)
                    Toast.makeText(
                        this@LoginActivity,
                        "welcomeBack",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(i)
                    finish()
//                Toast.makeText(this@LoginActivity, "Congrats, you have been created an acount", Toast.LENGTH_SHORT).show()
//                binding.submitButtonLogin.isEnabled = true
//                val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                startActivity(intent)
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Error:"+t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun saveSession(username: String, password: String) {
        prefHelper.put( Constant.PREF_USERNAME, username )
        prefHelper.put( Constant.PREF_PASSWORD, password )
        prefHelper.put( Constant.PREF_IS_LOGIN, true)
    }

    override fun onStart() {
        super.onStart()
        if (prefHelper.getBoolean(Constant.PREF_IS_LOGIN)) {
            moveIntent()
        }
    }

    private fun moveIntent() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()


//    private fun loginUser(){
//        inputEmail = binding.emailEditText.text.toString()
//        inputPassword = binding.passwordEditText.text.toString()
//
//        viewModel.login(inputEmail, inputPassword).observe(this) { result ->
//            if (result != null){
//                when(result) {
//                    is ResultState.Success -> {
//                        binding.submitButtonLogin.isEnabled = true
////                        viewModel.saveSession(
////                            UserModel(
////                                result.data.email,
////                                result.data.password,
////                            )
////                        )
//
//                        val intent = Intent(this@login, HomeFragment::class.java)
//                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//                        startActivity(intent)
//                        finish()
//                    }
//                    is ResultState.Error -> {
//                        binding.submitButtonLogin.isEnabled = true
//                        Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
//                    }
//                    is ResultState.Loading -> {
//                        binding.submitButtonLogin.isEnabled = false
//                    }
//                }
//            }
//        }
//    }
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

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

//    override fun onClick(v: View?){
//        when(v){
//            binding.submitButtonLogin -> {
//                loginUser()
//            }
//        }
//    }
}