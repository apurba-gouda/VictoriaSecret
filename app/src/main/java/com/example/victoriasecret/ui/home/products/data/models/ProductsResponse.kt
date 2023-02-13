package com.example.victoriasecret.ui.home.products.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
  @SerialName("data")
  val responseData: Response,
)

@Serializable
data class Response(
  @SerialName("products")
  val products: List<Product>,
)
