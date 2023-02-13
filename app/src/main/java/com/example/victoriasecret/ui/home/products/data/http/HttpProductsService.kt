package com.example.victoriasecret.ui.home.products.data.http

import com.example.victoriasecret.network.NetworkClient
import com.example.victoriasecret.ui.home.products.data.ProductsService
import com.example.victoriasecret.ui.home.products.data.models.ProductsResponse
import io.ktor.client.request.*

class HttpProductsService : ProductsService {

  override suspend fun getProducts(): ProductsResponse {
    return NetworkClient.getClient().get {
      url {
        path(NetworkClient.GET_PRODUCTS)
      }
    }
  }
}
