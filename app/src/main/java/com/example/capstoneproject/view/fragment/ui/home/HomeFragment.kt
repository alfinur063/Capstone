package com.example.capstoneproject.view.fragment.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.R
import com.example.capstoneproject.Recipe
import com.example.capstoneproject.Rekom
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.adapter.ListRecipeAdapter
import com.example.capstoneproject.adapter.ListRecomAdapter
import com.example.capstoneproject.databinding.FragmentHomeBinding
import com.example.capstoneproject.view.termandcondition.TermsAndConditionActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var btnMainFeature: CardView
    private lateinit var rvRekom: RecyclerView
    private val list = ArrayList<Rekom>()
//    private val viewModel by viewModels<HomeViewModel> {
//        ViewModelFactory.getInstance()
//    }
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        requireActivity().actionBar?.hide()

        val layoutManager1 : RecyclerView = view.findViewById(R.id.rekomenddasi_1)
        layoutManager1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val layoutManager2 : RecyclerView = view.findViewById(R.id.rekomendasi_2)
        layoutManager2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        rvRekom = view.findViewById(R.id.rekomenddasi_1)
        rvRekom.setHasFixedSize(true)
        list.addAll(getListRekom1())
        showRecyclerList(layoutManager1, getListRekom1())

//        rvRekom = view.findViewById(R.id.rekomenddasi_1A)
//        rvRekom.setHasFixedSize(true)
//        list.addAll(getListRekom1())
//        showRecyclerList()
//
//        rvRekom = view.findViewById(R.id.rekomenddasi_1B)
//        rvRekom.setHasFixedSize(true)
//        list.addAll(getListRekom1())
//        showRecyclerList()
//
        rvRekom = view.findViewById(R.id.rekomendasi_2)
        rvRekom.setHasFixedSize(true)
        list.addAll(getListRecom())
        showRecyclerList(layoutManager2, getListRecom())

        return view

    }

    private fun getListRekom1(): ArrayList<Rekom> {
        val dataName = resources.getStringArray(R.array.rekom1_name)
        val dataPhoto = resources.obtainTypedArray(R.array.rekom_image)
        val listRekom = ArrayList<Rekom>()
        for (i in dataName.indices) {
            val rekom = Rekom(dataName[i], dataPhoto.getResourceId(i, -1))
            listRekom.add(rekom)
        }
        return listRekom
    }

    private fun getListRecom(): ArrayList<Rekom> {
        val dataName = resources.getStringArray(R.array.rekom_name)
        val dataPhoto = resources.obtainTypedArray(R.array.rekom_image2)
        val listRekom = ArrayList<Rekom>()
        for (i in dataName.indices) {
            val rekom = Rekom(dataName[i], dataPhoto.getResourceId(i, -1))
            listRekom.add(rekom)
        }
        return listRekom
    }

    private fun showRecyclerList(recyclerView: RecyclerView, itemList: ArrayList<Rekom>) {
        recyclerView.hasFixedSize()
        recyclerView.adapter = ListRecomAdapter(itemList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMainFeature = view.findViewById(R.id.fitur_utama)
       btnMainFeature.setOnClickListener {
           val intent = Intent(requireActivity(), TermsAndConditionActivity::class.java)
           startActivity(intent)
       }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().actionBar?.hide()
        _binding = null
    }
}