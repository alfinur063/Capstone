package com.example.capstoneproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.Recipe as Recipe1

class ListRecipeAdapter(private val listRecipe: ArrayList<Recipe1>): RecyclerView.Adapter<ListRecipeAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items_user, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listRecipe.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (titlerecipe, description, imagerecipe) = listRecipe[position]
        holder.imgPhoto.setImageResource(imagerecipe)
        holder.tvName.text=titlerecipe
        holder.tvDescription.text = description
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_avatar)
        val tvName: TextView = itemView.findViewById(R.id.foodname)
        val tvDescription: TextView = itemView.findViewById(R.id.descripfood)

    }
}