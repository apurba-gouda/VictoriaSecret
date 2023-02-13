package com.example.victoriasecret.ui.home.products.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.victoriasecret.R
import com.example.victoriasecret.databinding.FragmentProductsBinding
import com.example.victoriasecret.ui.home.products.ProductsVMBuilder

class ProductsFragment : Fragment() {
  private lateinit var productFragmentBinding: FragmentProductsBinding
  private lateinit var vm: ProductsViewModel
  private val adapter: ProductsAdapter by lazy {
    ProductsAdapter(emptyList())
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    productFragmentBinding = FragmentProductsBinding.inflate(layoutInflater)

    vm = ProductsVMBuilder.build(this)
    vm.fetchProducts()
    setUpObservers()
    setUpRecyclerView()
    return productFragmentBinding.root
  }

  private fun setUpRecyclerView() {
    productFragmentBinding.productList.apply {
      layoutManager =
        LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
      adapter = adapter
    }
  }

  private fun setUpObservers() {
    vm.productsStream.observe(viewLifecycleOwner) {
      if (it.isNullOrEmpty()) return@observe
      adapter.updateProducts(it)
    }
  }

  companion object {
    private const val TAG = "ProductsFragment"
  }
}