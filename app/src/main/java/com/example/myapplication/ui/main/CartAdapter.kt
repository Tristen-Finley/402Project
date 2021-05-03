package com.example.myapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CartAdapter(private val ItemList: List<Item>) : RecyclerView.Adapter<CartAdapter.CartView>() {

    override fun getItemCount() = ItemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartView {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return CartView(itemView)
    }

    override fun onBindViewHolder(holder: CartView, position: Int) {
        val currentItem = ItemList[position]
        holder.textView.text = currentItem.item
    }

    class CartView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view)
        val button: Button = itemView.findViewById(R.id.add_to_cart)
    }
}