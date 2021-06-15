package org.techtown.pagingex.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import org.techtown.pagingex.paging.MyPagingRepository

// 데이터를 처리함
class MainViewModel(private val repository : MyPagingRepository) : ViewModel() {

    private val myCustomPosts2 : MutableLiveData<Int> = MutableLiveData()

    // 라이브 데이터 변경 시 다른 라이브 데이터 발행
    val result = myCustomPosts2.switchMap { queryString ->
        repository.getPost(queryString).cachedIn(viewModelScope)
    }

    // 라이브 데이터 변경
    fun searchPost(userId: Int) {
        myCustomPosts2.value = userId
    }
}