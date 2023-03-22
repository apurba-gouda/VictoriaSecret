package com.example.victoriasecret.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.victoriasecret.R
import com.example.victoriasecret.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(),
  NavController.OnDestinationChangedListener {

  private lateinit var binding: ActivityHomeBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityHomeBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val navHostFragment =
      supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHostFragment.navController
    binding.homeNavigation.setupWithNavController(navController)
    navController.addOnDestinationChangedListener(this)
  }

  override fun onResume() {
    super.onResume()
    println("This is branch 1.0.2")
  }

  override fun onDestinationChanged(
    controller: NavController,
    destination: NavDestination,
    arguments: Bundle?
  ) {
    if (destination.id == R.id.productsFragment) {
      binding.homeNavigation.visibility = View.VISIBLE
    }

    if (destination.id == R.id.productDetailsFragment) {
      binding.homeNavigation.visibility = View.GONE
    }
  }
}