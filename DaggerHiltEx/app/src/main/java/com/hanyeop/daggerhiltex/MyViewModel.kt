package com.hanyeop.daggerhiltex

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MyViewModel @Inject constructor(
    @Named("String2") string2 : String
) : ViewModel(){

    init{
        Log.d("test5", "$string2")
    }
}