package com.example.capstoneproject.view.termandcondition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import com.example.capstoneproject.MainActivity
import com.example.capstoneproject.R

class TermsAndConditionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_condition)


        val checkbox : CheckBox = findViewById(R.id.checkbox)
        when(checkbox) {

        }
    }
}