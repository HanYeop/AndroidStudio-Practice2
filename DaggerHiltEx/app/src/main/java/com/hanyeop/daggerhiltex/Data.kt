package com.hanyeop.daggerhiltex

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

//class Data {
//    var a = 10
//
//    fun set(){
//        Log.d("test5", "set: $a")
//        a = 20
//    }
//
//    fun get(){
//        Log.d("test5", "get: $a")
//    }
//}

class Data @Inject constructor(
    @Named("String1") private val str: String
) {
    var a = 10

    init {
        Log.d("test5", "string: $str")
    }

    fun set(){
        Log.d("test5", "set: $a")
        a = 20
    }

    fun get(){
        Log.d("test5", "get: $a")
    }
}