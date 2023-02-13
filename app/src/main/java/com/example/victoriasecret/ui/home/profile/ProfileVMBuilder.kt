package com.example.victoriasecret.ui.home.profile

import androidx.lifecycle.ViewModelProviders
import com.example.victoriasecret.ui.home.products.view.ProductsFragment
import com.example.victoriasecret.ui.home.profile.data.http.HttpProfileService
import com.example.victoriasecret.ui.home.profile.view.ProfileFragment
import com.example.victoriasecret.ui.home.profile.view.ProfileViewModel

object ProfileVMBuilder {

  fun build(fragment: ProfileFragment): ProfileViewModel {
    val factory = ProfileVMFactory(HttpProfileService())

    return ViewModelProviders.of(
      fragment,
      factory,
    )[ProfileViewModel::class.java]
  }
}
