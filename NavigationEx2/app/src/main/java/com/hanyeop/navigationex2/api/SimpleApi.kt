package com.hanyeop.navigationex2.api

import com.hanyeop.navigationex2.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("posts")
    suspend fun getPost(
        @Query("userId") userId : Int,
    ) : Response<List<Post>>
}