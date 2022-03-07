package com.hanyeop.flowex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.hanyeop.flowex.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val myViewModel : MyViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // 데이터바인딩
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        // 뷰모델 연결
        binding.vm = myViewModel

        // 뷰모델을 LifeCycle 에 종속시킴, LifeCycle 동안 옵저버 역할을 함
        binding.lifecycleOwner = this

//        // 1. LiveData
//        myViewModel.liveData.observe(this){
//            binding.textView.text = it.toString()
//        }
//
//        // 2. StateFlow
//        lifecycleScope.launchWhenStarted {
//            myViewModel.stateFlow.collectLatest {
//                binding.textView2.text = it.toString()
//            }
//        }

        // 3. SharedFlow
        lifecycleScope.launchWhenStarted {
            myViewModel.sharedFlow.collectLatest {
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}