package com.example.victoriasecret.ui.home.products.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.victoriasecret.ui.home.products.ProductsVMBuilder

class ProductsFragment : Fragment() {

  private lateinit var vm: ProductsViewModel
  private val adapter: ProductsAdapter by lazy {
    ProductsAdapter(emptyList())
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    vm = ProductsVMBuilder.build(this)
    setUpObservers()
    setUpRecyclerView()
    return inflater.inflate(R.layout.fragment_products, container, false)
  }

  fun setUpRecyclerView() {
    //Todo Set Recyclerview
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