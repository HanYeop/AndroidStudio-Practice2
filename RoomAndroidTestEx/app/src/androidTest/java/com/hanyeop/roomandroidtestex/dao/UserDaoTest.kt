package com.hanyeop.roomandroidtestex.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.hanyeop.roomandroidtestex.database.UserDatabase
import com.hanyeop.roomandroidtestex.model.User
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserDaoTest {


    /** 백그라운드 작업과 연관된 모든 아키텍처
     * 컴포넌트들을 같은(한개의) 스레드에서 실행되게 해서 테스트 결과들이 동기적으로 실행되게 함
     * livadata 테스트에 필수적으로 사용 **/
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: UserDao
    private lateinit var database: UserDatabase

    @Before
    fun setUp() {
        // inMemoryDatabaseBuilder = 프로세스 종료 시에 사라지는 메모리 형태의 데이터베이스
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UserDatabase::class.java
        ).build()
        dao = database.userDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun addUserTest() = runBlocking{
        val users = listOf(
            User(1,"Han",25),
            User(2,"Kim",26),
            User(3,"Choi",27)
        )

        for(i in users){
            dao.addUser(i)
        }

        val allUsers = dao.readAllData()
        Truth.assertThat(allUsers).isEqualTo(users)
    }
}