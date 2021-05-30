package com.hanyeop.recyclerviewdatabindingex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.recyclerviewdatabindingex.databinding.MainItemBinding

class MyAdapter()
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var userList = arrayListOf<User>()

    // 생성된 뷰 홀더에 값 지정
    class MyViewHolder(private val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root) {
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
        holder.bind(userList[position])
    }

    // 뷰 홀더의 개수 리턴
    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(data : ArrayList<User>){
        userList = data
        notifyDataSetChanged()
    }
}