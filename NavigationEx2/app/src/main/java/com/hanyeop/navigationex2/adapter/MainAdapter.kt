package com.hanyeop.navigationex2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.navigationex2.databinding.ItemLayoutBinding
import com.hanyeop.navigationex2.model.Post

class MainAdapter(private val listener: AdapterListener) : ListAdapter<Post, MainAdapter.MyViewHolder>(diffUtil) {

    // 생성된 뷰 홀더에 값 지정
    inner class MyViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                listener.onItemClicked()
            }
        }
        fun bind(post: Post) {
            binding.post = post
        }
    }

    // 어떤 xml 으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // 리스트 갱신
    override fun submitList(list: List<Post>?) {
        super.submitList(list)
    }

    // diffUtil 추가
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}