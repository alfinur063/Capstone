package com.example.capstoneproject.view.fragment.ui.Profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.capstoneproject.R
//import com.example.capstoneproject.database.preference.Constant
//import com.example.capstoneproject.database.preference.PrefHelper
import com.example.capstoneproject.databinding.FragmentProfileBinding
import com.example.capstoneproject.view.login.LoginActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
 //   private lateinit var sPH: PrefHelper
    private lateinit var buttonKeluar: Button
//    lateinit var prefHelper: PrefHelper
    private lateinit var username: TextView


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        init(view)
        //   sPH = PrefHelper(requireActivity())
//        prefHelper = PrefHelper(requireActivity())
//
//        username.text = prefHelper.getString(Constant.PREF_USERNAME)



        buttonKeluar.setOnClickListener {
      //      prefHelper.clear()
            val i = Intent(activity, LoginActivity::class.java)
            startActivity(i)
            Toast.makeText(activity, "Anda Berhasil Logout !", Toast.LENGTH_SHORT).show()
            activity?.finish()
        }
        return view
    }

    private fun moveIntent() {
        startActivity(Intent(context,LoginActivity::class.java))

    }

    private fun init(view: View) {
        buttonKeluar = view.findViewById<Button>(R.id.btn_logout)
        username = view.findViewById<TextView>(R.id.tv_username)


    }

}

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
