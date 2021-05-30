package com.hanyeop.recyclerviewdatabindingex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _userList = MutableLiveData<ArrayList<User>>()
    val userList : LiveData<ArrayList<User>>
        get() = _userList

    private var items = ArrayList<User>()

    init{
        items = arrayListOf(
                User("Han",25),
                User("Lee",33)
        )
        _userList.value = items
    }

    fun buttonClick(){
        val user = User("Test",20)
        items.add(user)
        _userList.value = items
    }
}