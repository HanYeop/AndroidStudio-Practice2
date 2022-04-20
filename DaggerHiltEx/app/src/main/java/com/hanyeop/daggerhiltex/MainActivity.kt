package com.hanyeop.daggerhiltex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.hanyeop.daggerhiltex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private val viewModel : MyViewModel by viewModels()

    @Inject
    lateinit var data : Data
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel
        data.set()

        val data2 = Data("test")
        data2.get()

        binding.apply {
            button.setOnClickListener {
                startActivity(Intent(this@MainActivity,SubActivity::class.java))
            }
        }
    }
}