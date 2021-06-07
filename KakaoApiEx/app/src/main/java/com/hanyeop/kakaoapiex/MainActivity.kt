package com.hanyeop.kakaoapiex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hanyeop.kakaoapiex.databinding.ActivityMainBinding
import com.hanyeop.kakaoapiex.repository.Repository
import com.hanyeop.kakaoapiex.viewmodel.MainViewModel
import com.hanyeop.kakaoapiex.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        binding.button.setOnClickListener {
            viewModel.searchImage()
        }

        viewModel.myCustomPosts.observe(this, Observer { result ->
            if(result.isSuccessful){
                Log.d("test5", "$result")
                for(i in result.body()!!.documents!!){
                    Log.d("test5", "$i")
                }
                binding.textView.text = result.body()!!.documents?.get(0)!!.image_url
            }
            else{
                Log.d("test5", "fail")
            }
        })
    }
}