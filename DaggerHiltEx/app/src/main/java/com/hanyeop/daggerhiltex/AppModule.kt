package com.hanyeop.daggerhiltex

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("String1")
    fun provideTestString() = "테스트 문자가 주입되었습니다."

//    @Singleton
//    @Provides
//    @Named("String2")
//    fun provideTestString2() = "2번째 테스트 문자가 주입되었습니다."

    @Singleton
    @Provides
    @Named("String2")
    fun provideTestString2(
        @ApplicationContext context : Context,
        @Named("String1") string1 : String
    ) = "${context.getString(R.string.string_string2)} 그리고, $string1"
}

//@Module
//@InstallIn(ActivityComponent::class)
//object AppModule {
//
//    @ActivityScoped
//    @Provides
//    fun provideTestString() = "테스트 문자가 주입되었습니다."
//
//}