package com.example.victoriasecret.ui.home.profile.data

import com.example.victoriasecret.ui.home.profile.data.models.Profile

interface ProfileService {
  suspend fun fetchProfile(): Profile
}
