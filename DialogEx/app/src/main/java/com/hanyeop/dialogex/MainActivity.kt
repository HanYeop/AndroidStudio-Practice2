package com.hanyeop.dialogex

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hanyeop.dialogex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CustomDialogListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initClickListener()
    }

    private fun initClickListener(){
        binding.apply {
            btnDialogCommon.setOnClickListener {
                showDialog()
            }
            btnDialogCustom.setOnClickListener {
                customDialog()
            }
        }
    }

    // 1. 일반 다이얼로그 띄우기
    private fun showDialog(){
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("타이틀입니다.")
            .setMessage("메세지입니다.")
            .setIcon(R.drawable.ic_launcher_foreground)
            .setPositiveButton("YES") { dialog , which ->
                // 기능구현
                binding.dialogText.text = "YES Click"
            }
            .setNegativeButton("NO"){ dialog, which ->
                // 기능구현
                binding.dialogText.text = "NO Click"
            }
            .create()
            .show()
    }

    // 2. 커스텀 다이얼로그 띄우기
    private fun customDialog(){
        val dialog = CustomDialog(this, this)
        dialog.show()
    }

    // 커스텀 다이얼로그에서 버튼 클릭 시
    override fun onOkButtonClicked() {
        // 기능 구현
        Toast.makeText(this, "버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show()
    }
}
