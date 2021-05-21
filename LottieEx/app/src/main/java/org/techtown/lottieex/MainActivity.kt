package org.techtown.lottieex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.lottieex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.animationView.setOnClickListener {
            binding.animationView.playAnimation()

        }
    }
}