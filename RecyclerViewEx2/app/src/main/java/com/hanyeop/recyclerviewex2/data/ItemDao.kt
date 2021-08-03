package com.hanyeop.recyclerviewex2.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hanyeop.recyclerviewex2.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    // OnConflictStrategy.IGNORE = 동일한 아이디가 있을 시 무시
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item : Item)

    @Query("SELECT * FROM item_table ORDER BY id ASC")
    fun readAllData() : Flow<List<Item>>
}