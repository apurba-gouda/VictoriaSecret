package com.example.victoriasecret.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

object NetworkClient {

  private const val BASE_URL = "https://run.mocky.io/"
  const val GET_PRODUCTS = ""
  const val GET_PROFILE = "${BASE_URL}v3/aaf97364-eedc-46a5-8f9e-56eb4b3cedd2"

  fun getClient(): HttpClient =
    HttpClient(Android) {
      install(Logging) {
        level = LogLevel.ALL
      }
      install(JsonFeature) {
        serializer = KotlinxSerializer()
      }
    }

}

