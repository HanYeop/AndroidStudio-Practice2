package com.hanyeop.navigationex2.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.hanyeop.navigationex2.ApplicationClass.Companion.TAG
import com.hanyeop.navigationex2.BaseFragment
import com.hanyeop.navigationex2.R
import com.hanyeop.navigationex2.adapter.AdapterListener
import com.hanyeop.navigationex2.adapter.MainAdapter
import com.hanyeop.navigationex2.databinding.FragmentOneBinding
import com.hanyeop.navigationex2.viewmodel.MainViewModel
import java.util.*

class OneFragment : BaseFragment<FragmentOneBinding>(R.layout.fragment_one),AdapterListener {

    private val mainViewModel by viewModels<MainViewModel>()
    private val mainAdapter = MainAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: One")
        super.onCreate(savedInstanceState)

        // 처음 생성시에만 실행할 메소드
        mainViewModel.getPost(Random().nextInt(10) + 1)
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView: One")
        super.onDestroyView()
    }

    override fun init() {
        Log.d(TAG, "init: One")

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

    // 아이템 클릭 시 DetailFragment 로 전환
    override fun onItemClicked() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView,DetailFragment())
            .addToBackStack(null)
            .commit()
    }
}