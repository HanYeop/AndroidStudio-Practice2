package com.hanyeop.customviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.hanyeop.customviewex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.apply {
            toolbarMain.setBackButtonClickEvent {
                Toast.makeText(this@MainActivity, "hi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}