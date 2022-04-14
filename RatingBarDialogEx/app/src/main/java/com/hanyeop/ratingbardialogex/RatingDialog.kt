package com.hanyeop.ratingbardialogex

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.hanyeop.ratingbardialogex.databinding.DialogRatingBinding

class RatingDialog(context: Context, private val listener: RatingListener) : Dialog(context) {

    private lateinit var binding: DialogRatingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogRatingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
    }

    private fun initClickListener(){
        binding.apply {
            // 연결된 Callback 리스너를 통해 MainActivity 에 Rating 전달
            btnOk.setOnClickListener {
                listener.onOkClicked(binding.ratingBar.rating)
                dismiss()
            }
            btnCancel.setOnClickListener {
                dismiss()
            }
        }
    }
}