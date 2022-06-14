package com.song.gomo.di

import com.song.gomo.data.net.ServiceCreator
import com.song.gomo.data.net.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class NetWorkModule {

    @Singleton
    @Provides
    fun providerRetrofit(): ApiService {
        return ServiceCreator.create()
    }

}