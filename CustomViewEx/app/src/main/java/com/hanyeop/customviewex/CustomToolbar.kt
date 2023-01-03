package com.hanyeop.customviewex

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import com.google.android.material.appbar.AppBarLayout
import com.hanyeop.customviewex.databinding.ToolbarDefaultBinding

class CustomToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
): AppBarLayout(context, attrs, defStyleAttr) {

    private var binding = ToolbarDefaultBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        attrs?.let { getAttrs(it) }
    }

    private fun getAttrs(attrs: AttributeSet){
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar)

        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray){
        binding.apply {
            val backImage = typedArray.getResourceId(R.styleable.CustomToolbar_back_image, R.drawable.ic_arrow_back)
            ivBackButton.setImageResource(backImage)

            val title = typedArray.getString(R.styleable.CustomToolbar_title)
            tvTitle.text = title
        }

        // 데이터를 캐싱해두어 가비지컬렉션에서 제외시키도록 하는 함수
        // typedArray 사용 후 호출해야하나, 커스텀뷰가 반복 사용되는 것이 아니라면 호출하지 않아도 무방하다.
        typedArray.recycle()
    }

    fun setBackImage(image: Int){
        binding.ivBackButton.setImageResource(image)
    }

    fun setTitle(title: String){
        binding.tvTitle.text = title
    }

    fun setBackButtonClickEvent(onClick: () -> Unit){
        binding.ivBackButton.setOnClickListener {
            onClick()
        }
    }
}