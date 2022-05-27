package com.hanyeop.dialogex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.hanyeop.dialogex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
    }

    private fun initClickListener(){
        binding.apply {
            btnDialogCommon.setOnClickListener {
                showDialog()
            }
        }
    }

    // 1. 일반 다이얼로그 띄우기
    private fun showDialog(){
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("타이틀입니다.")
            .setMessage("메세지입니다.")
            .setPositiveButton("YES") { dialog , which ->
                binding.dialogText.text = "YES Click"
            }
            .setNegativeButton("NO"){ dialog, which ->
                binding.dialogText.text = "NO Click"
            }
            .create()
            .show()
    }
}
