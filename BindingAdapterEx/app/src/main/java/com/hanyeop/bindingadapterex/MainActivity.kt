package com.hanyeop.bindingadapterex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hanyeop.bindingadapterex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.apply {
            recyclerView.adapter = MyAdapter(this@MainActivity)
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
        }
    }

    // TODO : 아이템 클릭 이벤트
    override fun onClicked(user: User) {
        Log.d("TEST5", "onClicked: $user")
    }
}