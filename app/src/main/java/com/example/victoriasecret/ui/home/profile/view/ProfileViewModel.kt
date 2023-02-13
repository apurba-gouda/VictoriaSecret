package com.example.victoriasecret.ui.home.profile.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.victoriasecret.ui.home.profile.data.ProfileService
import com.example.victoriasecret.ui.home.profile.data.models.Profile
import kotlinx.coroutines.launch

class ProfileViewModel(
  private val service: ProfileService,
) : ViewModel() {

  private val mutableProfile = MutableLiveData<Profile>()
  val profileStream: LiveData<Profile> = mutableProfile

  fun fetchProfile() {
    viewModelScope.launch {
      try {
        val response = service.fetchProfile()
        mutableProfile.value = response
      } catch (e: Exception) {
        handleException(e)
      }
    }
  }

  private fun handleException(e: Exception) {
    Log.i("TAG", "handleException: $e")
  }
}
