package com.example.capstoneproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.Recipe

class recipeAdapter(private val recipeList: ArrayList<Recipe>, val listener: (Recipe) -> Unit)
    : RecyclerView.Adapter<recipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.items_user, parent, false)
        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bindView(recipeList[position], listener)

        val currentItem = recipeList[position]
        holder.imageView.setImageResource(currentItem.imageRecipe)
        holder.titleRecipe.text = currentItem.titleRecipe
        holder.descRecipe.text = currentItem.descRecipe
        itemCount
    }

    override fun getItemCount(): Int {
        return recipeList.size

    }
    class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.img_avatar)
        val titleRecipe : TextView = itemView.findViewById(R.id.tv_username)
        val descRecipe : TextView = itemView.findViewById(R.id.tv_desc)

        fun bindView(Recipe: Recipe, listener: (Recipe) -> Unit){
            imageView.setImageResource(Recipe.imageRecipe)
            titleRecipe.text = Recipe.titleRecipe
            descRecipe.text = Recipe.descRecipe
            itemView.setOnClickListener{
                listener(Recipe)
            }
        }
    }
}