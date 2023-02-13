package com.example.victoriasecret.ui.home.products.view

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.victoriasecret.R
import com.example.victoriasecret.databinding.ItemProductBinding
import com.example.victoriasecret.extension.loadImage
import com.example.victoriasecret.ui.home.products.data.models.Product
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.asFlow

class ProductsAdapter(
  private var productList: List<Product>,
) : RecyclerView.Adapter<ProductsAdapter.ProductVH>() {

  private val itemChannel = BroadcastChannel<Product>(1)
  val itemClickFlow = itemChannel.asFlow()

  fun updateProducts(list: List<Product>) {
    productList = list
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
    val viewBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context))
    return ProductVH(viewBinding)
  }

  override fun onBindViewHolder(holder: ProductVH, position: Int) {
    holder.bindData(productList[position])
  }

  override fun getItemCount(): Int = productList.size

  inner class ProductVH(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

    init {
      binding.root.setOnClickListener {
        if (adapterPosition == RecyclerView.NO_POSITION) return@setOnClickListener
        //Register Listener here
        itemChannel.trySend(productList[adapterPosition])
      }
    }

    fun bindData(product: Product) {
      binding.apply {
        productName.text = product.name
        brandName.text = product.brand
        offerPrice.text = getPrice(itemView.context,product.offerPrice)
        price.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        price.text = getPrice(itemView.context,product.price)
        productIV.loadImage(product.productUrl)
      }
    }

    private fun getPrice(context: Context, price:String) :String{
      return context.resources.getString(R.string.price,price)
    }
  }

}