package com.hanyeop.flowlifecycleex

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hanyeop.flowlifecycleex.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


const val TAG = "test5"
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    private val flow: Flow<Int> = flow{
        for(i in 0 .. 1000){
            emit(i)
            delay(1000L)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this

        init()
    }

    private fun init(){
        initViewModelCallback()

        initClickListener()
    }

    private fun initClickListener(){
        binding.apply {
            button2.setOnClickListener {
                mainViewModel.startCounting()
            }
        }
    }

    private fun initViewModelCallback(){

        // 백그라운드에서도 계속 코루틴이 진행된다.
//        lifecycleScope.launch {
//            mainViewModel.countFlow.collectLatest {
//                Log.d(TAG, "Activity: $it")
//            }
//        }

//        // 백그라운드로 나가면 코루틴 일시 정지, 돌아오면 다시 시작
//        lifecycleScope.launchWhenStarted {
//            mainViewModel.countFlow.collectLatest {
//                Log.d(TAG, "Activity: $it")
//            }
//        }

        // 백그라운드로 나가면 코루틴 수집 정지, 돌아오면 시작
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.countFlow.collectLatest {
                    Log.d("TEST123", "Activity: $it")
                }
            }
        }

        // 백그라운드로 나가면 코루틴 취소, 돌아오면 처음부터 시작
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                flow.collectLatest {
//                    Log.d("TEST123", "Activity: $it")
//                }
//            }
//        }
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop!-------------")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart!-------------")
    }
}
