package com.example.capstoneproject.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.capstoneproject.database.api.ApiConfig
import com.example.capstoneproject.databinding.ActivityRegisterBinding
import com.example.capstoneproject.view.login.LoginActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
//    private val viewModel by viewModels<RegisterViewModel> {
//        ViewModelFactory.getInstance(this)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //regis to login page
        binding.goToLogin.setOnClickListener{
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
        binding.btnSign.setOnClickListener() {
            register()
        }


    }
    fun register() {
//        val password = binding.edPassword.text.toString()
//        val username = binding.edRegisterName.text.toString()
//        val email = binding.edEmail.text.toString()

        if (binding.edRegisterName.text!!.isEmpty()){
            binding.edRegisterName.error = "kolom username tidak boleh kosong"
            binding.edRegisterName.requestFocus()
            return
        } else if (binding.edEmail.text!!.isEmpty()) {
            binding.edEmail.error = "kolom username tidak boleh kosong"
            binding.edEmail.requestFocus()
            return
        }else if(binding.edPassword.text!!.isEmpty()){
            binding.edPassword.error = "kolom username tidak boleh kosong"
            binding.edPassword.requestFocus()
            return
        }
        ApiConfig.instanceRetrofit.register(binding.edRegisterName.text.toString(), binding.edEmail.text.toString(),binding.edPassword.text.toString()).enqueue(object :Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Toast.makeText(this@RegisterActivity, "Congrats, you have been created an acount", Toast.LENGTH_SHORT).show()
                        binding.btnSign.isEnabled = true
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error:"+t.message, Toast.LENGTH_SHORT).show()
            }

        })

    }

    //function to create account
//    private fun setUpAction() {
//        val username = binding.edRegisterName.text.toString()
//        val email = binding.edEmail.text.toString()
//        val password = binding.edPassword.text.toString()

//        viewModel.register(username, email, password).observe(this) { result ->
//            if (result != null) {
//                when (result) {
//                    is ResultState.Loading -> {
//                    binding.button.isEnabled = false
//                    }
//                    is ResultState.Success -> {
//                        Toast.makeText(this, "Congrats, you have been created an acount", Toast.LENGTH_SHORT).show()
//                        binding.button.isEnabled = true
//                        val intent = Intent(this@register, login::class.java)
//                        startActivity(intent)
//                    }
//                    is ResultState.Error -> {
//                        Toast.makeText(this, "your register is failed", Toast.LENGTH_SHORT).show()
//                        binding.button.isEnabled = true
//                    }
//                }
//            }
//        }
//
//    }
}