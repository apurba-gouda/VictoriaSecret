package com.example.victoriasecret.ui.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.victoriasecret.ui.home.profile.data.http.ProfileService
import com.example.victoriasecret.ui.home.profile.view.ProfileViewModel

class ProfileVMFactory(
  private val service: ProfileService,
) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return ProfileViewModel(service) as T
  }
}
