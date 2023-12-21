package com.example.capstoneproject.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.database.api.ApiConfig
import com.example.capstoneproject.database.repository.ResultState
import com.example.capstoneproject.databinding.ActivityRegisterBinding
import com.example.capstoneproject.view.login.LoginActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
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
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
        binding.btnSign.setOnClickListener {
            setUpAction()
        }
        supportActionBar?.hide()


    }
//    fun register() {
////        val password = binding.edPassword.text.toString()
////        val username = binding.edRegisterName.text.toString()
////        val email = binding.edEmail.text.toString()
//
//        if (binding.edRegisterName.text!!.isEmpty()){
//            binding.edRegisterName.error = "kolom username tidak boleh kosong"
//            binding.edRegisterName.requestFocus()
//            return
//        } else if (binding.edEmail.text!!.isEmpty()) {
//            binding.edEmail.error = "kolom username tidak boleh kosong"
//            binding.edEmail.requestFocus()
//            return
//        }else if(binding.edPassword.text!!.isEmpty()){
//            binding.edPassword.error = "kolom username tidak boleh kosong"
//            binding.edPassword.requestFocus()
//            return
//        }
//        ApiConfig.instanceRetrofit.register(binding.edRegisterName.text.toString(), binding.edEmail.text.toString(),binding.edPassword.text.toString()).enqueue(object :Callback<ResponseBody>{
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                Toast.makeText(this@RegisterActivity, "Congrats, you have been created an acount", Toast.LENGTH_SHORT).show()
//                        binding.btnSign.isEnabled = true
//                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
//                        startActivity(intent)
//
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                Toast.makeText(this@RegisterActivity, "Error:"+t.message, Toast.LENGTH_SHORT).show()
//            }
//
//        })
//
//    }

//    function to create account

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.loadingState.visibility = View.VISIBLE
        } else {
            binding.loadingState.visibility = View.GONE
        }
    }
    private fun setUpAction() {
        val username = binding.edRegisterName.text.toString()
        val email = binding.edEmail.text.toString()
        val password = binding.edPassword.text.toString()
//        when {
//            username.isEmpty() -> {
//                binding.edRegisterName.error = "Input Your Name"
//                binding.edRegisterName.requestFocus()
//            }
//
//            email.isEmpty() -> {
//                binding.edEmail.error = "Input Your Email"
//                binding.edEmail.requestFocus()
//            }
//
//            password.isEmpty() -> {
//                binding.edPassword.error = "Input your Password"
//                binding.edPassword.requestFocus()
//            }
        viewModel.register(username, email, password).observe(this) { result ->
                if (result != null){
                    when(result){
                        is ResultState.Loading ->{
                            showLoading(true)
                            binding.btnSign.isEnabled = false
                        }

                        is ResultState.Success -> {
                            Toast.makeText(this, "Selamat anda berhasil membuat akun", Toast.LENGTH_SHORT).show()
                            binding.btnSign.isEnabled = true
                            showLoading(false)
                            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                            startActivity(intent)
                        }
                        is ResultState.Error -> {
                            showLoading(false)
                            binding.btnSign.isEnabled = true
                            Toast.makeText(this, "your register is error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
    }

}
