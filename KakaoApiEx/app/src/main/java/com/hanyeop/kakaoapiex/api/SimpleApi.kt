package com.hanyeop.kakaoapiex.api

import com.hanyeop.kakaoapiex.model.ImageSearchResponse
import com.hanyeop.kakaoapiex.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SimpleApi {
    @GET("v2/search/image")
    suspend fun searchImage(
        @Header("Authorization") apiKey: String = Constants.AUTH_HEADER,
        @Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ) : Response<ImageSearchResponse>
}