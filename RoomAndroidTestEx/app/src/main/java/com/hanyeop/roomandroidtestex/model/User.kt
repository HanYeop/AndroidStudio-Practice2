package com.hanyeop.roomandroidtestex.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    // autoGenerate = true , 자동으로 PrimaryKey 생성해줌
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val age : Int
)
