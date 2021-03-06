package com.hanyeop.navigationex2.view

import com.hanyeop.navigationex2.BaseFragment
import com.hanyeop.navigationex2.R
import com.hanyeop.navigationex2.databinding.FragmentThreeBinding

class ThreeFragment : BaseFragment<FragmentThreeBinding>(R.layout.fragment_three) {

    override fun init() {
        binding.button.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,DetailFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}