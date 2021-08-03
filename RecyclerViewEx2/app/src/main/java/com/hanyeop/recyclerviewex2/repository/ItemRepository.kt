package com.hanyeop.recyclerviewex2.repository

import com.hanyeop.recyclerviewex2.data.ItemDao
import com.hanyeop.recyclerviewex2.model.Item
import kotlinx.coroutines.flow.Flow

// 앱에서 사용하는 데이터와 그 데이터 통신을 하는 역할
class ItemRepository(private val itemDao: ItemDao) {

    val readAllData : Flow<List<Item>> = itemDao.readAllData()

    suspend fun addItem(item: Item){
        itemDao.addItem(item)
    }
}