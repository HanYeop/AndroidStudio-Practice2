package com.hanyeop.kakaoapiex.repository

import com.hanyeop.kakaoapiex.api.RetrofitInstance
import com.hanyeop.kakaoapiex.model.ImageSearchResponse
import retrofit2.Response

class Repository {

    suspend fun searchImage(query : String, sort : String) : Response<ImageSearchResponse> {
        return RetrofitInstance.api.searchImage(query = query, sort = sort, page = 1, size = 5)
    }
}