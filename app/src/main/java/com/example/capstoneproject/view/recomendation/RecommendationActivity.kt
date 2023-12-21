package com.example.capstoneproject.view.recomendation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.database.dummy.Fooddummy
import com.example.capstoneproject.database.dummy.ListDummyAdapter
import com.example.capstoneproject.database.dummy.ListRekomendasiDummy
import com.example.capstoneproject.databinding.ActivityRecommendationBinding

class RecommendationActivity : AppCompatActivity() {

    private lateinit var rvFood: RecyclerView
    private val list: ArrayList<Fooddummy> = arrayListOf()
    private lateinit var binding: ActivityRecommendationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        supportActionBar?.hide()

        rvFood = findViewById(R.id.list_rekomendasi_makanan)
        rvFood.setHasFixedSize(true)

        list.addAll(ListRekomendasiDummy.listData)
        rvFood.layoutManager = LinearLayoutManager(this)
        val listCharFood = ListDummyAdapter(list)
        rvFood.adapter = listCharFood
    }
}