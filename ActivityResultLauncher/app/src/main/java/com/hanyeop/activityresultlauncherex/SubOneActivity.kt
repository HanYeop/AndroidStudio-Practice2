package com.hanyeop.activityresultlauncherex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hanyeop.activityresultlauncherex.Constant.Companion.ONE
import com.hanyeop.activityresultlauncherex.databinding.ActivitySubOneBinding

class SubOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 돌아갈 때 데이터 전달
        binding.returnButton.setOnClickListener {
            val intent = Intent(this@SubOneActivity,MainActivity::class.java)
            intent.putExtra("one", "1. SubOne 액티비티에서 보낸 메세지입니다.")

            setResult(ONE, intent)

            finish()
        }
    }
}