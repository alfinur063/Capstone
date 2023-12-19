package com.example.capstoneproject.view.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

//    private val viewModel by viewModels<SettingViewModel>{
//        ViewModelFactory.getInstance(this)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_setting, menu)

        return true
    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.logout -> {
//                viewModel.logout()
//                Intent(this@SettingActivity, login::class.java).also {
//                    startActivity(it)
//                }
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}