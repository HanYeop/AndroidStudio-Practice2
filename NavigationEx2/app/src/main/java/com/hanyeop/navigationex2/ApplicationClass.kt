package com.hanyeop.navigationex2

import android.app.Application
import com.hanyeop.navigationex2.repository.Repository

class ApplicationClass : Application(){

    companion object{
        const val TAG = "테스트"
    }

    override fun onCreate() {
        super.onCreate()

        initRepository()
    }

    private fun initRepository(){
        Repository.initialize()
    }
}