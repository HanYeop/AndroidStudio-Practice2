package com.hanyeop.navigationex2.view

import androidx.fragment.app.viewModels
import com.hanyeop.navigationex2.BaseFragment
import com.hanyeop.navigationex2.R
import com.hanyeop.navigationex2.adapter.MainAdapter
import com.hanyeop.navigationex2.databinding.FragmentTwoBinding
import com.hanyeop.navigationex2.viewmodel.MainViewModel

class TwoFragment : BaseFragment<FragmentTwoBinding>(R.layout.fragment_two) {

    private val mainViewModel by viewModels<MainViewModel>()
    private val mainAdapter = MainAdapter()

    override fun init() {
        mainViewModel.getPost(2)

        binding.apply {
            recyclerView.adapter = mainAdapter
        }

        mainViewModel.postList.observe(viewLifecycleOwner){
            mainAdapter.submitList(it)
        }
    }
}