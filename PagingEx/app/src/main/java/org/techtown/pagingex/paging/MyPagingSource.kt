package org.techtown.pagingex.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.techtown.pagingex.api.SimpleApi
import org.techtown.pagingex.model.Post
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

/*
simpleApi : 데이터를 제공하는 인스턴스
userId : 쿼리를 위한 값
 */
class MyPagingSource(
    private val simpleApi : SimpleApi,
    private val userId : Int
) : PagingSource<Int,Post>(){

    // 데이터 로드
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        // LoadParams : 로드할 키와 항목 수 , LoadResult : 로드 작업의 결과
        return try {
            // 키 값이 없을 경우 기본값을 사용함
            val position = params.key ?: STARTING_PAGE_INDEX

            // 데이터를 제공하는 인스턴스의 메소드 사용
            val response = simpleApi.getCustomPost2(
                userId = userId,
                sort = "id",
                order = "asc"
            )

//            val response = simpleApi.getCustomPost()

            val post = response?.body()

            /* 로드에 성공 시 LoadResult.Page 반환
            data : 전송되는 데이터
            prevKey : 이전 값 (위 스크롤 방향)
            nextKey : 다음 값 (아래 스크롤 방향)
             */
            LoadResult.Page(
                data = post!!,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = null
            )

            // 로드에 실패 시 LoadResult.Error 반환
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    // 데이터가 새로고침되거나 첫 로드 후 무효화되었을 때 키를 반환하여 load()로 전달
    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        TODO("Not yet implemented")
    }
}