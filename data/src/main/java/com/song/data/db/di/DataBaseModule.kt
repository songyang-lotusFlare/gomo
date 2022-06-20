package com.song.data.db.di

import android.content.Context
import com.song.data.db.GomoDatabase
import com.song.data.db.profile_info.GomoUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface DataBaseModule {

    @Provides
    @Singleton
    fun providerGomoDatabase(@ApplicationContext context: ApplicationContext) : GomoDatabase =
        GomoDatabase.getInstance(context as Context)

    @Provides
    @Singleton
    fun providerGomoUserDao(gomoDatabase: GomoDatabase) : GomoUserDao =
        gomoDatabase.userDao()

    //todo: add more Dao ...

}