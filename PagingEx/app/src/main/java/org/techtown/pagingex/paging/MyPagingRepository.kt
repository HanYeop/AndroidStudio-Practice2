package org.techtown.pagingex.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import org.techtown.pagingex.api.RetrofitInstance

class MyPagingRepository {

    fun getPost(userId : Int) =
        Pager(
           config = PagingConfig(
               pageSize = 5,
               maxSize = 20,
               enablePlaceholders = false
           ),
            // 사용할 메소드 선언
           pagingSourceFactory = { MyPagingSource(RetrofitInstance.api,userId)}
        ).liveData
}