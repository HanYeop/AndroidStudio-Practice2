package com.hanyeop.recyclerviewdatabindingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hanyeop.recyclerviewdatabindingex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // 뷰모델 연결
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = mainViewModel

        // 리사이클러뷰 어댑터 연결
        myAdapter = MyAdapter()
        binding.recyclerView.adapter = myAdapter

        mainViewModel.userList.observe(this, Observer {
            myAdapter.setData(it)
        })

    }
}