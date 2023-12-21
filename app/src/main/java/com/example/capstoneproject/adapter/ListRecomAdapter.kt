package com.example.capstoneproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.Recipe
import com.example.capstoneproject.Rekom


class ListRecomAdapter (private val listRekom: ArrayList<Rekom>): RecyclerView.Adapter<ListRecomAdapter.ListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listRekom.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(name,photo) = listRekom[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text=name
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.food_pic)
        val tvName: TextView = itemView.findViewById(R.id.food_title)
    }

}