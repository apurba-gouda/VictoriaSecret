package com.example.victoriasecret.ui.home.products.view

import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.victoriasecret.R
import com.example.victoriasecret.databinding.FragmentProductDetailsBinding
import com.example.victoriasecret.extension.loadImage
import com.example.victoriasecret.ui.home.products.data.models.Product


class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private var product : Product? = null
    val args by navArgs<ProductDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       binding = FragmentProductDetailsBinding.inflate(layoutInflater)
       product = args.ProductDetail

       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderUIData(product)
    }

    private fun renderUIData(product: Product?) {
        if(product==null) return
        binding.productIV.loadImage(product.productUrl)
        binding.brand.text = product.brand
        binding.productName.text = product.name
        binding.offerPrice.text = getPrice(requireContext(), product.offerPrice)
        binding.price.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        binding.price.text = getPrice(requireContext(),product.price)
        binding.productDescription.text = product.productDesc
    }
    private fun getPrice(context: Context, price:String) :String{
        return context.resources.getString(R.string.price,price)
    }

}