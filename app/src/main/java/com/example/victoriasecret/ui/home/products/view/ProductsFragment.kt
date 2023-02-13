package com.example.victoriasecret.ui.home.products.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.victoriasecret.databinding.FragmentProductsBinding
import com.example.victoriasecret.ui.home.products.ProductsVMBuilder
import kotlinx.coroutines.launch


class ProductsFragment : Fragment() {
  private lateinit var productFragmentBinding: FragmentProductsBinding
  private lateinit var vm: ProductsViewModel
  private val productsAdapter: ProductsAdapter by lazy {
    ProductsAdapter(emptyList())
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    productFragmentBinding = FragmentProductsBinding.inflate(layoutInflater)
    vm = ProductsVMBuilder.build(this)

    vm.fetchProducts()
    setUpRecyclerView()
    setUpObservers()

    return productFragmentBinding.root
  }

  private fun setUpRecyclerView() {
    productFragmentBinding.productList.apply {
      layoutManager =
        GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
      adapter = productsAdapter
    }
  }

  private fun setUpObservers() {
    vm.productsStream.observe(viewLifecycleOwner) {
      if (it.isNullOrEmpty()) return@observe
      productsAdapter.updateProducts(it)
    }

    viewLifecycleOwner.lifecycleScope.launch {
      handleProductItemTap()
    }
  }

  suspend fun handleProductItemTap(){
    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
      productsAdapter.itemClickFlow.collect {
        val action = ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(it)
        findNavController().navigate(action)
      }
    }
  }

  companion object {
    private const val TAG = "ProductsFragment"
  }
}