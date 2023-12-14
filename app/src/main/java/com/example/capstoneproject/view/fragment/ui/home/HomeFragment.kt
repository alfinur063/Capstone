package com.example.capstoneproject.view.fragment.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneproject.R
import com.example.capstoneproject.ViewModelFactory
import com.example.capstoneproject.databinding.FragmentHomeBinding
import com.example.capstoneproject.view.termandcondition.TermsAndConditionActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var btnMainFeature: Button

//    private val viewModel by viewModels<HomeViewModel> {
//        ViewModelFactory.getInstance()
//    }
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)


        _binding?.rekomenddasi1?.layoutManager = LinearLayoutManager(context)
        _binding?.rekomendasi2?.layoutManager = LinearLayoutManager(context)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMainFeature = view.findViewById(R.id.main_feature)
       btnMainFeature.setOnClickListener {
           val intent = Intent(requireActivity(), TermsAndConditionActivity::class.java)
           startActivity(intent)
       }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}