package com.example.tabapplication.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tabapplication.R
import com.example.tabapplication.databinding.RowItemBinding

class ItemsAdapter : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.text1.text =
            holder.binding.root.context.resources.getString(
                R.string.recycler_view_text,
                position.toString()
            )
        Log.d("lmao", position.toString())
    }

    override fun getItemCount(): Int {
        return 20
    }
}

class MyViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)