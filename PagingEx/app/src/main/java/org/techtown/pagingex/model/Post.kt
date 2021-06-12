package org.techtown.pagingex.model

import com.google.gson.annotations.SerializedName

// DTO(Data Transfer Object). 서버로부터 JSON 형식으로 통신하기위함.
data class Post(
    @SerializedName("userId")
    val myUserId : Int,
    val id : Int,
    val title : String,
    val body : String
)
