package com.hanyeop.navigationex2.view

import android.os.Bundle
import com.hanyeop.navigationex2.BaseFragment
import com.hanyeop.navigationex2.R
import com.hanyeop.navigationex2.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.hideNavi(true)
    }

    override fun init() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        MainActivity.hideNavi(false)
    }
}