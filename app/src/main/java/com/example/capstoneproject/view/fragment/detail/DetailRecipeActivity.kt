package com.example.capstoneproject.view.fragment.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.capstoneproject.R
import com.example.capstoneproject.Recipe
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.database.repository.ResultState
import com.example.capstoneproject.databinding.ActivityDetailRecipeBinding
import com.example.capstoneproject.view.fragment.ui.search.SearchFragment

class DetailRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailRecipeBinding
    private val viewModel by viewModels<DetailViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //showDetailFood()

//        val intentTitle = intent.getStringExtra("intent_title")
//        val intentImage = intent.getStringExtra("intent_image")
//        supportActionBar!!.title = intentTitle
//        val imageView = findViewById<ImageView>(R.id.img_item_photo)
//        Glide.with(this)
//            .load(intentImage )
//            .placeholder(R.drawable.logo)
//            .error(R.drawable.logo)
//            .into(imageView)

        val namaFood = binding.judulMaknanan
        val imgMakan = binding.photoMakanan
        val descFood = binding.deskripsiMakanan
        val khasiatFood = binding.khasiatMakanan
        val bahanMkn = binding.teksBahan
        val stepbuat = binding.deskripsiLangkah

        val qNama = intent.getStringExtra(EXTRA_NAME)
        val qPhoto = intent.getIntExtra(EXTRA_PHOTO, 0)
        val qDesc = intent.getStringExtra(EXTRA_DESC)
        val qKhasiat = intent.getStringExtra(EXTRA_KHASIAT)
        val qBahan = intent.getStringExtra(EXTRA_BAHAN)
        val qStep = intent.getStringExtra(EXTRA_STEP)

        namaFood.text = qNama
        imgMakan.setImageResource(qPhoto)
        descFood.text = qDesc
        khasiatFood.text = qKhasiat
        bahanMkn.text = qBahan
        stepbuat.text = qStep

    }
    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressDetail.visibility = View.VISIBLE
        } else {
            binding.progressDetail.visibility = View.GONE
        }
    }
    private fun showDetailFood(){
        intent.getStringExtra(FOOD_ID).let {
            viewModel.goToDetail(it as Int).observe(this) { detail ->
                if (detail != null){
                    when(detail){
                        is ResultState.Success -> {
                            showLoading(false)
                            Glide.with(binding.root.context)
                                .load(detail.data.result?.image)
                                .into(binding.photoMakanan)
                            binding.judulMaknanan.text = detail.data.result?.deskripsi
                            binding.deskripsiMakanan.text = detail.data.result?.deskripsi
                            binding.khasiatMakanan.text = detail.data.result?.khasiat
                            binding.teksBahan.text = detail.data.result?.ingredients
                            binding.deskripsiLangkah.text = detail.data.result?.steps
                        }
                        is ResultState.Error -> {
                            showLoading(false)
                            Toast.makeText(this, "Gagal memuat detail data", Toast.LENGTH_SHORT).show()
                        }
                        is ResultState.Loading -> {
                            showLoading(true)
                        }
                    }
                }
            }
        }
    }
    companion object {
        var FOOD_ID = "ID_FOOD"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_detail"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_KHASIAT = "extra_khasiat"
        const val EXTRA_BAHAN = "extra_bahan"
        const val EXTRA_STEP = "extra_step"
    }
}