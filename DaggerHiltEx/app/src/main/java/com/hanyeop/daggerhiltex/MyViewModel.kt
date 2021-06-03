package com.hanyeop.daggerhiltex

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import javax.inject.Named

class MyViewModel @ViewModelInject constructor(
    @Named("String2") string2 : String
) : ViewModel(){

    init{
        Log.d("test5", "$string2")
    }
}