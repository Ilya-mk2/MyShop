package com.example.myshop

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.domain.product.ProductModel
import com.example.myshop.registration.presentation.ScrollFragment

class ProductsAdapter (products : ArrayList<ProductModel>, private val listener : OnItemClickListener): RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {
        private val pList = products

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return pList.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int){
        val productItem = pList[position]

        holder.priceTextView.text = productItem.price.price
        holder.title.text = productItem.title
        holder.subtitle.text = productItem.subtitle
    }

    inner class ProductHolder(itemView : View) : RecyclerView.ViewHolder(itemView), OnClickListener {
        val title : TextView = itemView.findViewById(R.id.title_textView)
        val subtitle: TextView = itemView.findViewById(R.id.subtitle_textView)
        val priceTextView : TextView = itemView.findViewById(R.id.price_textView)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
        val position = adapterPosition
            if(adapterPosition != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }

    }
    fun interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}