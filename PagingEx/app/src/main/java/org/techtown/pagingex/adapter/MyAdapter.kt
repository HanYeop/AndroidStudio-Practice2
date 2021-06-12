package org.techtown.pagingex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.pagingex.databinding.ItemLayoutBinding
import org.techtown.pagingex.model.Post

class MyAdapter
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()

    class MyViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    // 어떤 xml 으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.userIdText.text = myList[position].myUserId.toString()
        holder.binding.idText.text = myList[position].id.toString()
        holder.binding.titleText.text = myList[position].title
        holder.binding.bodyText.text = myList[position].body
    }

    // 뷰 홀더의 개수 리턴
    override fun getItemCount(): Int {
        return myList.size
    }

    // 데이터 변경시 리스트 다시 할당
    fun setData(newList : List<Post>){
        myList = newList
        // 새로고침
        notifyDataSetChanged()
    }
}