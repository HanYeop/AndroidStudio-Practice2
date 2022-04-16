package com.hanyeop.bindingadapterex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.bindingadapterex.databinding.MainItemBinding

class MyAdapter()
    : ListAdapter <User, MyAdapter.MyViewHolder> (diffUtil) {

    // 생성된 뷰 홀더에 값 지정
    inner class MyViewHolder(private val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentUser : User) {
            binding.user = currentUser
        }
    }

    // 어떤 xml 으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // 리스트 갱신
    override fun submitList(list: List<User>?) {
        super.submitList(list)
    }

    // diffUtil 추가
    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<User>(){
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}