package com.hanyeop.navigationex2.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId")
    val myUserId : Int,
    val id : Int,
    val title : String,
    val body : String
)
