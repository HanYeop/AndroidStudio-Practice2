package com.hanyeop.weatherapiex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.hanyeop.weatherapiex.databinding.ActivityMainBinding
import com.hanyeop.weatherapiex.util.Constants.Companion.TAG
import com.hanyeop.weatherapiex.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // 뷰모델 생성
    private val viewModel by viewModels<WeatherViewModel>()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 데이터바인딩
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel.getWeather("JSON",14,1,
            20220322,1100,"63","89")

        viewModel.weatherResponse.observe(this){
            for(i in it.body()?.response!!.body.items.item){
                Log.d(TAG, "$i")
            }
        }
    }
}