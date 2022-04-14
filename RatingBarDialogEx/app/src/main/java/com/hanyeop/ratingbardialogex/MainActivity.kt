package com.hanyeop.ratingbardialogex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hanyeop.ratingbardialogex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RatingListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
    }

    private fun initClickListener(){
        binding.apply {
            btnRating.setOnClickListener {
                val dialog = RatingDialog(this@MainActivity, this@MainActivity)
                dialog.show()
            }
            btnSub.setOnClickListener {
                val intent = Intent(this@MainActivity,SubActivity::class.java)
                startActivity(intent)
            }
        }
    }

    // 연결된 Callback 리스너를 통해 Rating 받아와 표시
    override fun onOkClicked(rating: Float) {
        binding.apply {
            textRating.text = rating.toString()
            ratingBar.rating = rating
        }
    }
}