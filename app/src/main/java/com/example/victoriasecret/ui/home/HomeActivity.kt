package com.example.victoriasecret.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.example.victoriasecret.R
import com.example.victoriasecret.databinding.ActivityHomeBinding
import io.ktor.client.features.*
import io.ktor.client.request.*

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

  override fun onDestinationChanged(
    controller: NavController,
    destination: NavDestination,
    arguments: Bundle?
  ) {
    if (destination.id == R.id.productsFragment) {
      Toast.makeText(this, "product clicked", Toast.LENGTH_SHORT).show()
    }
    if (destination.id == R.id.profileFragment) {
      Toast.makeText(this, "profile clicked", Toast.LENGTH_SHORT).show()
    }

  }

}