package com.example.capstoneproject.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstoneproject.database.response.ResultItem
import com.example.capstoneproject.databinding.ItemsUserBinding
import com.example.capstoneproject.view.fragment.detail.DetailRecipeActivity

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


class RecipeAdapter (private val results: List<ResultItem>)
    : RecyclerView.Adapter<RecipeAdapter.ListFoodHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFoodHolder {
        val binding = ItemsUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListFoodHolder(binding)
    }

    override fun onBindViewHolder(holder: ListFoodHolder, position: Int) {
        val listFood = results[position]
        holder.bind(listFood)
    }


    override fun getItemCount(): Int = results.size

//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val result = results[position]
//        holder
//    }
//        holder.textView.text = result.food_name
//        Glide.with(holder.view)
//            .load(result.image)
//            .placeholder(R.drawable.logo)
//            .error(R.drawable.logo)
//            .centerCrop()
//            .into(holder.imageView)
//        holder.view.setOnClickListener { listener.onClick( result ) }
//    }

    class ListFoodHolder(private val binding: ItemsUserBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(food: ResultItem){
            Glide.with(binding.root.context)
                .load(food.image)
                .into(binding.imgAvatar)
            binding.descripfood.text = food.deskripsi
            binding.foodname.text = food.foodName

            itemView.setOnClickListener{
                val idFood = food.idFood
                val goToDetail = Intent(binding.root.context, DetailRecipeActivity::class.java)
                goToDetail.putExtra(DetailRecipeActivity.FOOD_ID, idFood)
                binding.root.context.startActivity(goToDetail)
            }
        }
    }



//    class ViewHolder(val view: View ) : RecyclerView.ViewHolder(view){
//        val textView = view.findViewById<TextView>(R.id.foodname)
//        val imageView = view.findViewById<ImageView>(R.id.img_avatar)
//    }

//    fun setData(recipe: List<SearchModel.Result>){
//        this.results.clear()
//        this.results.addAll(recipe)
//        notifyDataSetChanged()
//    }
//
//    interface OnAdapterListener {
//        fun onClick(result: SearchModel.Result)
//    }
    }


