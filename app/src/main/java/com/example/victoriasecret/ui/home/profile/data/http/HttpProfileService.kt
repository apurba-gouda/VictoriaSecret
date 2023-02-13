package com.example.victoriasecret.ui.home.profile.data.http

import com.example.victoriasecret.network.NetworkClient
import com.example.victoriasecret.ui.home.profile.data.models.Profile
import io.ktor.client.request.*

class HttpProfileService : ProfileService {

  override suspend fun fetchProfile(): Profile {
    return NetworkClient.getClient()
      .get {
        url ( NetworkClient.GET_PROFILE )
      }
  }
}
