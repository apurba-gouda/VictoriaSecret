package com.example.victoriasecret.ui.home.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.victoriasecret.ui.home.products.data.http.HttpProductsService
import kotlinx.coroutines.launch

class ProductsFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_products, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  override fun onResume() {
    super.onResume()
    lifecycleScope.launch {
      try {
        val res = getProducts()
        Log.i(TAG, "onResume: Res: $res")
      } catch (e: Exception) {
        Log.i(TAG, "onResume: Exception : ${e.message}")
      }
    }
  }

  private suspend fun getProducts() {
    HttpProductsService().getProducts()
  }

  companion object {
    private const val TAG = "ProductsFragment"
  }
}