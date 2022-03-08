package com.hanyeop.flowex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _liveData = MutableLiveData(100)
    val liveData: LiveData<Int> = _liveData

    private val _stateFlow = MutableStateFlow(200)
    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<String>(
        replay = 0, extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun changeLiveData(){
        viewModelScope.launch {
            repeat(10){
                _liveData.value = _liveData.value?.plus(1)
                delay(1000L)
            }
        }
    }

    fun changeStateFlow(){
        viewModelScope.launch {
            repeat(10){
                _stateFlow.value = _stateFlow.value.plus(1)
                delay(1000L)
            }
        }
    }

    fun changeSharedFlow(){
        viewModelScope.launch {
            _sharedFlow.emit("안녕하세요")
        }
    }
}