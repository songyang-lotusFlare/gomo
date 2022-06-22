package ph.com.globe.data.db.di

import android.content.Context

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ph.com.globe.data.db.profile_info.GomoUserDao
import ph.com.globe.data.db.GomoDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class DataBaseModule {
    @Provides
    @Singleton
    fun providerGomoDatabase(@ApplicationContext context: Context): GomoDatabase =
        GomoDatabase.getInstance(context as Context)

    @Provides
    @Singleton
    fun providerGomoUserDao(gomoDatabase: GomoDatabase): GomoUserDao =
        gomoDatabase.userDao()

    //todo: add more Dao ...
}
