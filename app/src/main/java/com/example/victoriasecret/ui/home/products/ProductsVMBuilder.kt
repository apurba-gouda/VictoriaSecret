package com.example.victoriasecret.ui.home.products

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import com.example.victoriasecret.ui.home.products.data.http.HttpProductsService
import com.example.victoriasecret.ui.home.products.view.ProductsFragment
import com.example.victoriasecret.ui.home.products.view.ProductsViewModel

object ProductsVMBuilder {

  fun build(fragment: ProductsFragment): ProductsViewModel {
    val factory = ProductsVMFactory(HttpProductsService())

    return ViewModelProviders.of(
      fragment,
      factory,
    )[ProductsViewModel::class.java]
  }
}