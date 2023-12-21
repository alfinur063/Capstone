package com.example.capstoneproject.view.fragment.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.Recipe
import com.example.capstoneproject.adapter.ListRecipeAdapter

class SearchFragment : Fragment() {
    private lateinit var rvRecipe: RecyclerView
    private val list = ArrayList<Recipe>()



    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val view = inflater.inflate(R.layout.fragment_search, container, false)

        rvRecipe = view.findViewById(R.id.rv_user)
        rvRecipe.setHasFixedSize(true)
        list.addAll(getListRecipe())
        showRecyclerList()

        return view
    }

    private fun showRecyclerList() {
        rvRecipe.layoutManager = LinearLayoutManager(requireContext())
        val listRecipeAdapter = ListRecipeAdapter(list)
        rvRecipe.adapter = listRecipeAdapter
    }

    private fun getListRecipe(): ArrayList<Recipe> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_image)
        val listRecipe = ArrayList<Recipe>()
        for (i in dataName.indices) {
            val recipe = Recipe(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listRecipe.add(recipe)
    }
    return listRecipe
}
}


