package com.hanyeop.activityresultlauncherex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hanyeop.activityresultlauncherex.Constant.Companion.TWO
import com.hanyeop.activityresultlauncherex.databinding.ActivitySubTwoBinding

class SubTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.returnButton.setOnClickListener {
            val intent = Intent(this@SubTwoActivity,MainActivity::class.java)
            intent.putExtra("two", "2. SubTwo 액티비티에서 보낸 메세지입니다.")

            setResult(TWO, intent)

            finish()
        }
    }
}