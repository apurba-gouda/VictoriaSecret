package com.example.victoriasecret.ui.home.products.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.victoriasecret.ui.home.products.data.models.Product

class ProductsAdapter(
  private var productList: List<Product>,
) : RecyclerView.Adapter<ProductsAdapter.ProductVH>() {

  fun updateProducts(list: List<Product>) {
    productList = list
    notifyDataSetChanged()
  }

  inner class ProductVH(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {

  }

  override fun onBindViewHolder(holder: ProductVH, position: Int) {

  }

  override fun getItemCount(): Int = productList.size

}