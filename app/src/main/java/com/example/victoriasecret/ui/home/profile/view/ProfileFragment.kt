package com.example.victoriasecret.ui.home.profile.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.victoriasecret.R
import com.example.victoriasecret.databinding.FragmentProductsBinding
import com.example.victoriasecret.databinding.FragmentProfileBinding
import com.example.victoriasecret.ui.home.products.ProductsVMBuilder
import com.example.victoriasecret.ui.home.products.view.ProductsViewModel
import com.example.victoriasecret.ui.home.profile.ProfileVMBuilder
import com.example.victoriasecret.ui.home.profile.data.models.Profile

class ProfileFragment : Fragment() {
    private lateinit var profileFragmentBinding: FragmentProfileBinding
    private lateinit var vm: ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        profileFragmentBinding = FragmentProfileBinding.inflate(layoutInflater)
        vm = ProfileVMBuilder.build(this)

        vm.fetchProfile()
        setUpObservers()

        return profileFragmentBinding.root
    }

    private fun setUpObservers() {
        vm.profileStream.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            renderProfileUIData(it)
        }
    }

    private fun renderProfileUIData(profile: Profile) {
        profileFragmentBinding.apply {
            firstName.text =  profile.firstname.plus(" ").plus(profile.lastName)
            dob.text  = profile.dob
            pointsEarnedValueTV.text = profile.pointsEarned
            walletBalanceValueTV.text = getPrice(requireContext(),profile.walletBalance)
            addressTV.text = profile.address
            profileTV.text = profile.firstname.first().toString()
        }
    }

    private fun getPrice(context: Context, price:String) :String{
        return context.resources.getString(R.string.price,price)
    }

}