package com.hanyeop.bindingadapterex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hanyeop.bindingadapterex.databinding.ActivityMainBinding

const val TAG = "TEST5"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
        }
    }
}