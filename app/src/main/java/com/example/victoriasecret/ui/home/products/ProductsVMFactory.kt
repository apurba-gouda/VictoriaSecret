package com.example.victoriasecret.ui.home.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.victoriasecret.ui.home.products.data.ProductsService
import com.example.victoriasecret.ui.home.products.view.ProductsViewModel

class ProductsVMFactory(
  private val productsService: ProductsService,
) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return ProductsViewModel(productsService) as T
  }
}
