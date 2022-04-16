package com.hanyeop.bindingadapterex

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

object MyBindingAdapter {

    // 어댑터 아이템 연결, 갱신
    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items : ArrayList<User>){

        // 어댑터 최초 연결
        if(recyclerView.adapter == null) {
            val adapter = MyAdapter()
            recyclerView.adapter = adapter
        }

        val myAdapter = recyclerView.adapter as MyAdapter

        // 자동 갱신
        myAdapter.submitList(items.toMutableList())
    }

    // 이미지 바인딩
    @BindingAdapter("image")
    @JvmStatic
    fun setImage(imageView: ImageView, imageUrl: Any){
        Glide.with(imageView.context)
            .load(imageUrl)
            .override(200,200)
            .circleCrop().into(imageView)
    }
}