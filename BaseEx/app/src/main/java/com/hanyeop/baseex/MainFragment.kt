package com.hanyeop.baseex

import com.hanyeop.baseex.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val _stateFlow = MutableStateFlow(200)
    val stateFlow = _stateFlow.asStateFlow()

    override fun init() {
        binding.apply {
            main = this@MainFragment
        }
    }

    fun changeStateFlow(){
        _stateFlow.value = _stateFlow.value.plus(1)
    }
}