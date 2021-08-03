package com.hanyeop.recyclerviewex2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(
    // autoGenerate = true , 자동으로 PrimaryKey 생성해줌
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val description : String
)
