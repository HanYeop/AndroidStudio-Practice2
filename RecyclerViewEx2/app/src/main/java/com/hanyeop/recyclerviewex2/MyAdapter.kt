package com.hanyeop.recyclerviewex2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.recyclerviewex2.databinding.LayoutItemBinding
import com.hanyeop.recyclerviewex2.model.Item

class MyAdapter : ListAdapter<Item, MyAdapter.ItemViewHolder>(diffUtil) {
    inner class ItemViewHolder(private val binding : LayoutItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item){
            binding.apply {
                nameText.text = item.name
                descriptionText.text = item.description
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<Item>?) {
        super.submitList(list)
    }

    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<Item>(){
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}