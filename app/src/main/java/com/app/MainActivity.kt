package com.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.app.databinding.FragmentMainActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var binding: FragmentMainActivityBinding? = null

    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let { navController ->
            binding?.bottomNavigation?.setupWithNavController(navController)
        }
//        controller?.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.authorizationFragment -> {
//                    findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.GONE
//                }
//            }
//        controller?.addOnDestinationChangedListener { _, destination, _ ->
//            if (destination.id == R.id.authorizationFragment) {
//                findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.GONE
//            } else {
//                findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.VISIBLE
//            }
//
  //      }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        controller?.navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}