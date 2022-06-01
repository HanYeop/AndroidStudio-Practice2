package com.hanyeop.navigationex2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanyeop.navigationex2.SingleLiveEvent
import com.hanyeop.navigationex2.model.Post
import com.hanyeop.navigationex2.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val repository = Repository.get()

    private val _postList = MutableLiveData<MutableList<Post>>()
    val postList : LiveData<MutableList<Post>> get() = _postList

    private val _oneState = SingleLiveEvent<Boolean>()
    val oneState : LiveData<Boolean> get() = _oneState

    fun getPost(userId : Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPost(userId).let { response ->
                if(response.isSuccessful){
                    _postList.postValue(response.body() as MutableList<Post>)
                }
                else{
                    Log.d("tag", "getPost: error")
                }
            }
        }
    }

    fun upOneFragment(){
        _oneState.call()
    }
}