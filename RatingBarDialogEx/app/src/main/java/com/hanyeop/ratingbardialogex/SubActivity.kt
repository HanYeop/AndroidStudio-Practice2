package com.hanyeop.ratingbardialogex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hanyeop.ratingbardialogex.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            baseRatingBar.rating = 3f // setter
            Toast.makeText(this@SubActivity,
                "${baseRatingBar.rating}", Toast.LENGTH_SHORT).show() // getter
        }
    }
}