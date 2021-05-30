package com.hanyeop.recyclerviewdatabindingex

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object MyBindingAdapter{

    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items : ArrayList<User>){

        if(recyclerView.adapter == null)
            recyclerView.adapter = MyAdapter()

        val myAdapter = recyclerView.adapter as MyAdapter

        myAdapter.userList = items
        myAdapter.notifyDataSetChanged()
    }

}