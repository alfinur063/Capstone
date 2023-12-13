package com.example.capstoneproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.capstoneproject.R
import com.example.capstoneproject.Recipe
import com.example.capstoneproject.view.fragment.ui.search.SearchFragment

class DetailRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_recipe)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Recipe = intent.getParcelableExtra<Recipe>(SearchFragment.INTENT_PARCELABLE)

        val imageRecipe = findViewById<ImageView>(R.id.img_item_photo)
        val titleRecipe = findViewById<TextView>(R.id.tv_item_name)
        val descRecipe = findViewById<TextView>(R.id.tv_item_description)

        imageRecipe.setImageResource(Recipe?.imageRecipe!!)
        titleRecipe.text = Recipe.titleRecipe
        descRecipe.text = Recipe.descRecipe

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}