package com.example.capstoneproject.view.termandcondition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import com.example.capstoneproject.MainActivity
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ActivityTermsAndConditionBinding
import com.example.capstoneproject.view.question.QuestionActivity

class TermsAndConditionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermsAndConditionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsAndConditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goToQuestion.setOnClickListener {
            startActivity(Intent(this@TermsAndConditionActivity, QuestionActivity::class.java))
        }
        supportActionBar?.hide()




    }
}