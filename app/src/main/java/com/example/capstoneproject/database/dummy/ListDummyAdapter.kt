package com.example.capstoneproject.database.dummy

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.view.fragment.detail.DetailRecipeActivity

class ListDummyAdapter(private val listFood : ArrayList<Fooddummy>): RecyclerView.Adapter<ListDummyAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail_recipe, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val contex = holder.itemView.context
        val (name, description, photo, khasiat, bahan, step) = listFood[position]

        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.imgPhoto.id = photo
        holder.tvKhasiat.text = khasiat
        holder.tvBahan.text = bahan
        holder.tvStep.text = step


        holder.itemView.setOnClickListener{
            val goToDetail = Intent(contex,DetailRecipeActivity::class.java)
            goToDetail.putExtra(DetailRecipeActivity.EXTRA_NAME, name)
            goToDetail.putExtra(DetailRecipeActivity.EXTRA_PHOTO, photo)
            goToDetail.putExtra(DetailRecipeActivity.EXTRA_DESC, description)
            goToDetail.putExtra(DetailRecipeActivity.EXTRA_KHASIAT, khasiat)
            goToDetail.putExtra(DetailRecipeActivity.EXTRA_BAHAN, bahan)
            goToDetail.putExtra(DetailRecipeActivity.EXTRA_STEP, step)
        }
    }



    override fun getItemCount(): Int {
        return listFood.size
    }


    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgPhoto: ImageView = itemView.findViewById(R.id.photo_makanan)
        val tvName: TextView = itemView.findViewById(R.id.judul_maknanan)
        val tvDescription: TextView = itemView.findViewById(R.id.deskripsi_makanan)
        val tvKhasiat: TextView = itemView.findViewById(R.id.khasiat_makanan)
        val tvBahan: TextView = itemView.findViewById(R.id.teks_bahan)
        val tvStep: TextView = itemView.findViewById(R.id.deskripsi_langkah)
    }
}