package com.hanyeop.recyclerviewex2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.recyclerviewex2.Constants.Companion.LEFT_POSITION
import com.hanyeop.recyclerviewex2.Constants.Companion.RIGHT_POSITION
import com.hanyeop.recyclerviewex2.databinding.LayoutItemBinding
import com.hanyeop.recyclerviewex2.databinding.LayoutItemRightBinding
import com.hanyeop.recyclerviewex2.model.Item
import java.lang.RuntimeException

class MyAdapter : ListAdapter<Item, RecyclerView.ViewHolder>(diffUtil) {

    // 왼쪽 뷰홀더
    inner class LeftViewHolder(private val binding : LayoutItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item){
            binding.apply {
                nameText.text = item.name
                descriptionText.text = item.description
            }
        }
    }

    // 오른쪽 뷰홀더
    inner class RightViewHolder(private val binding : LayoutItemRightBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item){
            binding.apply {
                nameText.text = item.name
                descriptionText.text = item.description
            }
        }
    }

    // 타입에 따라 다른 뷰홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // viewType = getItemViewType 의 리턴 값
        return when(viewType){
            LEFT_POSITION ->{
                val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                LeftViewHolder(binding)
            }
            RIGHT_POSITION ->{
                val binding = LayoutItemRightBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                RightViewHolder(binding)
            }
            else -> throw RuntimeException("Error")
        }
    }

    // 타입에 따라 바인딩
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)

        when(currentItem.type){
            LEFT_POSITION -> (holder as LeftViewHolder).bind(currentItem)
            RIGHT_POSITION -> (holder as RightViewHolder).bind(currentItem)
        }
    }

    // 리스트 갱신
    override fun submitList(list: List<Item>?) {
        super.submitList(list)
    }

    // 아이템 타입 리턴
    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }

    // diffUtil 추가
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