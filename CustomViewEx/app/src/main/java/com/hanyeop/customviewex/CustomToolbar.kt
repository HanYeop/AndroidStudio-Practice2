package com.hanyeop.customviewex

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.AppBarLayout

class CustomToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr : Int = 0
): AppBarLayout(context, attrs, defStyleAttr) {

    init {
        // TODO : binding
        val view = LayoutInflater.from(context).inflate(R.layout.toolbar_default, this, false)
        addView(view)
        attrs?.let { getAttrs(it) }
    }

    private fun getAttrs(attrs: AttributeSet){
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar)

        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray){
        val backImage = typedArray.getResourceId(R.styleable.CustomToolbar_back_image, R.drawable.ic_arrow_back)
        findViewById<ImageView>(R.id.iv_back_button).setImageResource(backImage)

        val title = typedArray.getString(R.styleable.CustomToolbar_title)
        findViewById<TextView>(R.id.tv_title).text = title

        typedArray.recycle()
    }

    fun setBackImage(image: Int){
        findViewById<ImageView>(R.id.iv_back_button).setImageResource(image)
    }

    fun setTitle(title: String){
        findViewById<TextView>(R.id.tv_title).text = title
    }

    fun setBackButtonClickEvent(onClick: () -> Unit){
        findViewById<ImageView>(R.id.iv_back_button).setOnClickListener {
            onClick()
        }
    }
}