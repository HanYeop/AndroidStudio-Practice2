package com.hanyeop.baseex

import android.os.Bundle
import android.view.View
import com.hanyeop.baseex.databinding.FragmentMainBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val _stateFlow = MutableStateFlow(200)
    val stateFlow = _stateFlow.asStateFlow()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            main = this@MainFragment
        }
    }

    override fun init() {

    }

    fun changeStateFlow(){
        _stateFlow.value = _stateFlow.value.plus(1)
    }
}