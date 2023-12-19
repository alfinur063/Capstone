package com.example.capstoneproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstoneproject.R
import com.example.capstoneproject.view.fragment.ui.search.SearchModel

//class recipeAdapter(private val recipeList: ArrayList<Recipe>, val listener: (Recipe) -> Unit)
//    : RecyclerView.Adapter<recipeAdapter.RecipeViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
//        val itemView =
//            LayoutInflater.from(parent.context).inflate(R.layout.items_user, parent, false)
//        return RecipeViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
//        holder.bindView(recipeList[position], listener)
//
//        val currentItem = recipeList[position]
//        holder.imageView.setImageResource(currentItem.imageRecipe)
//        holder.titleRecipe.text = currentItem.titleRecipe
//        holder.descRecipe.text = currentItem.descRecipe
//        itemCount
//    }
//
//    override fun getItemCount(): Int {
//        return recipeList.size
//
//    }
//    class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val imageView : ImageView = itemView.findViewById(R.id.img_avatar)
//        val titleRecipe : TextView = itemView.findViewById(R.id.tv_username)
//        val descRecipe : TextView = itemView.findViewById(R.id.tv_desc)
//
//        fun bindView(Recipe: Recipe, listener: (Recipe) -> Unit){
//            imageView.setImageResource(Recipe.imageRecipe)
//            titleRecipe.text = Recipe.titleRecipe
//            descRecipe.text = Recipe.descRecipe
//            itemView.setOnClickListener{
//                listener(Recipe)
//            }
//        }
//    }
//}


class RecipeAdapter (var results: ArrayList<SearchModel.Result>, val listener: OnAdapterListener)
    : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.items_user, parent, false)
    )

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
   //     holder.view.findViewById(R.id.food_name) = result.food_name
        Glide.with(holder.view)
            .load(result.image)
            .placeholder(R.drawable.logo)
            .error(R.drawable.logo)
            .centerCrop()
            .into(holder.view.findViewById(R.id.img_avatar))
        holder.view.setOnClickListener { listener.onClick( result ) }
    }

    class ViewHolder(val view: View ) : RecyclerView.ViewHolder(view)

    fun setData(recipe: List<SearchModel.Result>){
        this.results.clear()
        this.results.addAll(recipe)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(result: SearchModel.Result)
    }
    }


