package com.example.victoriasecret.ui.home.products.data

import com.example.victoriasecret.ui.home.products.data.models.ProductsResponse

interface ProductsService {
  suspend fun getProducts(): ProductsResponse
}