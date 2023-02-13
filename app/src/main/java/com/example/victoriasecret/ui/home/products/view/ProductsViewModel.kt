package com.example.victoriasecret.ui.home.products.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.victoriasecret.ui.home.products.data.ProductsService
import com.example.victoriasecret.ui.home.products.data.models.Product
import kotlinx.coroutines.launch

class ProductsViewModel(
  private val productsService: ProductsService,
) : ViewModel() {

  private val mutableProducts = MutableLiveData<List<Product>>()
  val productsStream: LiveData<List<Product>> = mutableProducts

  fun fetchProducts() {
    viewModelScope.launch {
      try {
        val responseProducts = productsService.getProducts()
        mutableProducts.value = responseProducts.responseData.products
      } catch (e: Exception) {
        handleException(e)
      }
    }
  }

  private fun handleException(e: Exception) {
    Log.i("TAG", "handleException: $e")
  }
}