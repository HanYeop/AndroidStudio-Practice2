package com.hanyeop.navigationex2.view

import androidx.fragment.app.viewModels
import com.hanyeop.navigationex2.BaseFragment
import com.hanyeop.navigationex2.R
import com.hanyeop.navigationex2.adapter.MainAdapter
import com.hanyeop.navigationex2.databinding.FragmentOneBinding
import com.hanyeop.navigationex2.viewmodel.MainViewModel

class OneFragment : BaseFragment<FragmentOneBinding>(R.layout.fragment_one) {

    private val mainViewModel by viewModels<MainViewModel>()
    private val mainAdapter = MainAdapter()

    override fun init() {

        mainViewModel.getPost(1)

        binding.apply {
            recyclerView.adapter = mainAdapter
        }

        mainViewModel.postList.observe(viewLifecycleOwner){
            mainAdapter.submitList(it)
        }
    }
}