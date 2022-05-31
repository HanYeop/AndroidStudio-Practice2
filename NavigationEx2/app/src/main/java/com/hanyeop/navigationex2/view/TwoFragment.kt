package com.hanyeop.navigationex2.view

import androidx.fragment.app.viewModels
import com.hanyeop.navigationex2.BaseFragment
import com.hanyeop.navigationex2.R
import com.hanyeop.navigationex2.adapter.MainAdapter
import com.hanyeop.navigationex2.databinding.FragmentTwoBinding
import com.hanyeop.navigationex2.viewmodel.MainViewModel
import java.util.*

class TwoFragment : BaseFragment<FragmentTwoBinding>(R.layout.fragment_two) {

    private val mainViewModel by viewModels<MainViewModel>()
    private val mainAdapter = MainAdapter()

    override fun init() {

        mainViewModel.getPost(Random().nextInt(10) + 1)

        binding.apply {
            recyclerView.adapter = mainAdapter

            // 새로고침 시 api 다시 호출 (1~10)
            pullRefresh.setOnRefreshListener {
                mainViewModel.getPost(Random().nextInt(10) + 1)
            }
        }

        mainViewModel.postList.observe(viewLifecycleOwner){
            mainAdapter.submitList(it)
            binding.pullRefresh.isRefreshing = false
        }
    }
}