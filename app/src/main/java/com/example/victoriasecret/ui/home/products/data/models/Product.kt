package com.example.victoriasecret.ui.home.products.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
  @SerialName("id")
  val id: String,
  @SerialName("brand")
  val brand: String,
  @SerialName("name")
  val name: String,
  @SerialName("productDesc")
  val productDesc: String,
  @SerialName("price")
  val price: String,
  @SerialName("offerPrice")
  val offerPrice: String,
  @SerialName("productUrl")
  val productUrl: String,
)
