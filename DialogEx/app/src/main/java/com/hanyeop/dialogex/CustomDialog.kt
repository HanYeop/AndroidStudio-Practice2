package com.hanyeop.dialogex

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.hanyeop.dialogex.databinding.DialogCustomBinding

class CustomDialog(context: Context, private val listener: CustomDialogListener): Dialog(context) {

    private lateinit var binding: DialogCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_custom,
        null, false)

        setContentView(binding.root)

        // 다이얼로그 사이즈 조절
        context.dialogResize(this,0.8f,0.4f)

        // 배경 투명하게 바꿔줌
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // 취소 불가능
        setCancelable(false)

        // 다이얼로그 배경 제거
        window!!.setDimAmount(0f)

        binding.apply {
            // 버튼 클릭 시 리스너 메소드 호출
            button.setOnClickListener {
                listener.onOkButtonClicked()
            }
        }
    }
}