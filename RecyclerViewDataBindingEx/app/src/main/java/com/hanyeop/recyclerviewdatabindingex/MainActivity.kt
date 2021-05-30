package com.hanyeop.recyclerviewdatabindingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hanyeop.recyclerviewdatabindingex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
//    private lateinit var mainViewModel: MainViewModel
    private lateinit var myAdapter: MyAdapter
    private val TAG = "test5"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        myAdapter = MyAdapter()
        binding.recyclerView.adapter = myAdapter

        myAdapter.userList = mutableListOf(
            User("Han",25),
            User("Lee",33)
        )

        binding.button.setOnClickListener {
            myAdapter.userList.add(User("test",50))
            Log.d(TAG, "onCreate: 실행")
        }
    }
}