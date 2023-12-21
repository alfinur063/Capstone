package com.example.capstoneproject.view.fragment.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.Recipe
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.adapter.RecipeAdapter
import com.example.capstoneproject.database.repository.ResultState
import com.example.capstoneproject.databinding.FragmentSearchBinding
import com.example.capstoneproject.view.fragment.ui.home.HomeFragment

class SearchFragment : Fragment() {

    private val TAG: String = "Search"
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var recipeArrayList: ArrayList<Recipe>



    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>

    private lateinit var binding: FragmentSearchBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val viewModel by viewModels<SearchModel> {
        ViewModelFactory.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
        // val view = inflater.inflate(R.layout.fragment_search, container, false)

//         recyclerView = view.findViewById(R.id.rv_user)
//         recyclerView.layoutManager = LinearLayoutManager(context)
//
//        setHasOptionsMenu(true)
//        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.inflate(layoutInflater)

        listFoods()

        //dataInitialize()
//        getDataFromApi()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_user)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
//      recyclerView.adapter = recipeAdapter(recipeArrayList) {
//            val intent = Intent(context, DetailRecipeActivity::class.java)
//            intent.putExtra(INTENT_PARCELABLE, it)
//            startActivity(intent)
//        }
    }

//    private fun getDataFromApi() {
//     //  showLoading(true)
//        ApiConfig.instanceRetrofit.recipe().enqueue(object : Callback<SearchModel> {
//            override fun onResponse(call: Call<SearchModel>, response: Response<SearchModel>) {
//      //          showLoading(false)
//                if (response.isSuccessful) {
//                    showResult(response.body()!!)
//                }
//            }
//
//            override fun onFailure(call: Call<SearchModel>, t: Throwable) {
//                printLog(t.toString())
//        //        showLoading(false)
//            }
//
//        })
//    }

    private fun showLoading(loading: Boolean) {
       binding.progressBar.visibility = if (loading)
        View.VISIBLE else View.GONE
    }

//    private fun showResult(results: SearchModel) {
//        for (result in results.result) printLog("title: ${result.food_name}")
//        recipeAdapter.setData(results.result)
//    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

//    override fun onResume(){
//        super.onResume()
//        viewModel.listOfFood()
//    }
    private fun listFoods(){

//        viewModel.getSession().observe(requireActivity()){
//            if (!it.isLogin ){
//                val intent = Intent(requireActivity(), HomeFragment::class.java)
//                startActivity(intent)
//            }else{
//        viewModel.listOfFood().observe(requireActivity()){ listfoods ->
//        if (listfoods != null){
//            when(listfoods){
//                is ResultState.Success -> {
//                    val list = RecipeAdapter(listfoods.data?.result!!)
//                    binding.rvUser.adapter = list
//                }
//                is ResultState.Error -> {
//                    Toast.makeText(requireContext(), "gagal menampilkan list maknan", Toast.LENGTH_SHORT).show()
//                }
//                is ResultState.Loading -> {
//                    showLoading(true)
//                }
//            }
//        }
//        }
            }


    }





//    private fun dataInitialize() {
//        recipeAdapter = RecipeAdapter(arrayListOf(), object : RecipeAdapter.OnAdapterListener {
//            override fun onClick(result: SearchModel.Result) {
//                startActivity(
//                    Intent(requireContext(), DetailRecipeActivity::class.java)
//                        .putExtra("intent_title", result.food_name)
//                        .putExtra("intent_image", result.image)
//                )
//            }
//        })
//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(requireContext())
//            adapter = recipeAdapter
//        }
//    }
//        recipeArrayList = arrayListOf<Recipe>()
//
//        image = arrayOf(
//            R.drawable.logo,
//            R.drawable.logo
//        )
//        title = arrayOf(
//            getString(R.string.nasgor),
//            getString(R.string.sayur)
//        )
//        descriptions = arrayOf(
//            getString(R.string.decnasi),
//            getString(R.string.decsayur)
//        )
//        for (i in image.indices) {
//
//            val recipe = Recipe(image[i], title[i], descriptions[i])
//            recipeArrayList.add(recipe)
//        }




//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.search_menu, menu)
//        val searchItem = menu.findItem(R.id.search)
//        val searchView = searchItem.actionView as SearchView
//
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                // Handle the search query submission
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                // Handle the search query text change
//                // You may want to filter your data based on the newText
//                return false
//            }
//        })
//
//        super.onCreateOptionsMenu(menu, inflater)
//    }



