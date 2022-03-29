package com.hanyeop.activityresultlauncherex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.hanyeop.activityresultlauncherex.Constant.Companion.ONE
import com.hanyeop.activityresultlauncherex.Constant.Companion.TWO
import com.hanyeop.activityresultlauncherex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            // SubOneActivity 이동
            oneButton.setOnClickListener {
                val intent = Intent(this@MainActivity,SubOneActivity::class.java)
                activityResultLauncher.launch(intent)
            }

            // SubTwoActivity 이동
            twoButton.setOnClickListener {
                val intent = Intent(this@MainActivity,SubTwoActivity::class.java)
                activityResultLauncher.launch(intent)
            }
        }
    }

    private val activityResultLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){

        // SubOne에서 결과를 받아옴
        if(it.resultCode == ONE){
            val intent = it.data
            val returnValue = intent!!.getStringExtra("one")
            Toast.makeText(this, returnValue.toString(), Toast.LENGTH_SHORT).show()
        }

        // SubTwo에서 결과를 받아옴
        else if(it.resultCode == TWO){
            val intent = it.data
            val returnValue = intent!!.getStringExtra("two")
            Toast.makeText(this, returnValue.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}