package org.techtown.pagingex.api

import org.techtown.pagingex.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

// 가능한 HTTP 동작들을 정의해놓은 인터페이스
interface SimpleApi {
    @GET("posts")
    suspend fun getCustomPost2(
        @Query("userId") userId : Int,
        @Query("_sort") sort : String,
        @Query("_order") order : String
    ): Response<List<Post>>

//    @GET("posts")
//    suspend fun getCustomPost(): Response<List<Post>>
}