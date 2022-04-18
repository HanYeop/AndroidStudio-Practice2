package com.hanyeop.bindingadapterex

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

object MyBindingAdapter {

    // 어댑터 아이템 연결, 갱신
    @BindingAdapter("items")
    @JvmStatic
    fun RecyclerView.setItems(items : ArrayList<User>){

        // 어댑터 최초 연결
        if(this.adapter == null) {
            val adapter = MyAdapter()
            this.adapter = adapter
        }

        val myAdapter = this.adapter as MyAdapter

        // 자동 갱신
        myAdapter.submitList(items.toMutableList())
    }

    // 이미지 바인딩
    @BindingAdapter("image")
    @JvmStatic
    fun ImageView.setImage (imageUrl: Any){
        Glide.with(this.context)
            .load(imageUrl)
            .override(200,200)
            .circleCrop().into(this)
    }
}