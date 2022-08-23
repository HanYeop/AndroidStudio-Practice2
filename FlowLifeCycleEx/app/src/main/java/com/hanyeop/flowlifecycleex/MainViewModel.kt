package com.hanyeop.flowlifecycleex

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _countFlow = MutableSharedFlow<Int>()
    val countFlow get() = _countFlow.asSharedFlow()

    fun startCounting(){
        viewModelScope.launch(Dispatchers.IO) {
            for(i in 1 .. 10){
                _countFlow.emit(i)
                Log.d(TAG, "startCounting: $i")
                delay(1000L)
            }
        }
    }
}