package com.glen.aacbasic.presentation

import androidx.recyclerview.widget.RecyclerView
import com.glen.aacbasic.data.Flower
import com.glen.aacbasic.databinding.ItemFlowerBinding

class FlowerViewHolder(
    private val binding: ItemFlowerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Flower) {
        binding.item = item
    }

    fun unbind() {
        binding.item = null
    }
}