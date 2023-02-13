package com.example.victoriasecret.ui.home.profile.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profile(
  @SerialName("id")
  val id: String,
  @SerialName("username")
  val username: String,
  @SerialName("firstname")
  val firstname: String,
  @SerialName("lastName")
  val lastName: String,
  @SerialName("dob")
  val dob: String,
  @SerialName("address")
  val address: String,
  @SerialName("pointsEarned")
  val pointsEarned: String,
  @SerialName("walletBalance")
  val walletBalance: String,
)
