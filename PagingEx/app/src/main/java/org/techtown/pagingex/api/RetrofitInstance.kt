package org.techtown.pagingex.api

import org.techtown.pagingex.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 인터페이스를 사용하는 인스턴스. Builder는 BASE_URL와  Converter를 설정
object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}