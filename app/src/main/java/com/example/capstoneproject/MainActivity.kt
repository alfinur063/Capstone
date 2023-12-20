package com.example.capstoneproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
//import com.example.capstoneproject.database.preference.PrefHelper
import com.example.capstoneproject.databinding.ActivityMainBinding
import com.example.capstoneproject.view.fragment.ui.Profile.ProfileFragment
import com.example.capstoneproject.view.fragment.ui.home.HomeFragment
import com.example.capstoneproject.view.fragment.ui.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment()
    val fragmentProfile: Fragment = ProfileFragment()
    val fragmentSearch: Fragment = SearchFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var binding: ActivityMainBinding
//    private lateinit var sPH: PrefHelper

//    private val viewModel by viewModels<MainViewModel> {
//        ViewModelFactory.getInstance(this)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
 //       sPH = PrefHelper(this)
      //  buttonNavigation()


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_bar_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        viewModel.getSession().observe(this) { UserSession ->
//            if (!UserSession.isLogin) {
//                val intent = Intent(this, login::class.java)
//                startActivity(intent)
//                finish()
            }
        }



//        private fun buttonNavigation() {
//            fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
//            fm.beginTransaction().add(R.id.container, fragmentSearch).hide(fragmentSearch).commit()
//            fm.beginTransaction().add(R.id.container, fragmentProfile).hide(fragmentProfile)
//                .commit()
//
//            bottomNavigationView = binding.navView
//            menu = bottomNavigationView.menu
//            menuItem = menu.getItem(0)
//            menuItem.isChecked = true
//
//            bottomNavigationView.setOnNavigationItemSelectedListener { item ->
//
//                when (item.itemId) {
//                    R.id.navigation_home -> {
//                        callFragment(0, fragmentHome)
//                    }
//
//                    R.id.navigation_search -> {
//                        callFragment(0, fragmentSearch)
//                    }
//
//                    R.id.navigation_profile -> {
//
//                        if (sPH.getStatusLogin()) {
//                            callFragment(1, fragmentProfile)
//                        } else {
//                            startActivity(Intent(this, LoginActivity::class.java))
//                        }
//                    }
//                }
//                false
//            }
//        }
//
//            private fun callFragment(index: Int, fragment: Fragment) {
//                menuItem = menu.getItem(index)
//                menuItem.isChecked = true
//                fm.beginTransaction().hide(active).show(fragment).commit()
//                active = fragment
//            }
//        }

