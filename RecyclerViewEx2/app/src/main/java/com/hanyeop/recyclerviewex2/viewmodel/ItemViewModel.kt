package com.hanyeop.recyclerviewex2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hanyeop.recyclerviewex2.data.ItemDatabase
import com.hanyeop.recyclerviewex2.model.Item
import com.hanyeop.recyclerviewex2.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// 뷰모델은 DB에 직접 접근하지 않아야함. Repository 에서 데이터 통신.
class ItemViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<Item>>
    private val repository : ItemRepository

    init {
        val itemDao = ItemDatabase.getDatabase(application)!!.itemDao()
        repository = ItemRepository(itemDao)
        readAllData = repository.readAllData.asLiveData()
    }

    fun addItem(item : Item){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(item)
        }
    }
}