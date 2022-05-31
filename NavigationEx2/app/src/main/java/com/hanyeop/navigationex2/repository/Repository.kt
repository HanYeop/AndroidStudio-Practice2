package com.hanyeop.navigationex2.repository

import com.hanyeop.navigationex2.api.RetrofitInstance
import com.hanyeop.navigationex2.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(userId : Int) : Response<List<Post>> = RetrofitInstance.api.getPost(userId)

    companion object {
        private var INSTANCE: Repository? = null

        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = Repository()
            }
        }

        fun get(): Repository {
            return INSTANCE ?:
            throw IllegalStateException("Repository must be initialized")
        }
    }
}