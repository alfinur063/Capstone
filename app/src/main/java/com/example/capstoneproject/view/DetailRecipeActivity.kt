package com.example.capstoneproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.capstoneproject.R
import com.example.capstoneproject.Recipe
import com.example.capstoneproject.view.fragment.ui.search.SearchFragment

class DetailRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recipe)

        val intentTitle = intent.getStringExtra("intent_title")
        val intentImage = intent.getStringExtra("intent_image")
        supportActionBar!!.title = intentTitle
        val imageView = findViewById<ImageView>(R.id.img_item_photo)
        Glide.with(this)
            .load(intentImage )
            .placeholder(R.drawable.logo)
            .error(R.drawable.logo)
            .into(imageView)
    }
}