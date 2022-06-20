package ph.com.globe.gomo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import ph.com.globe.gomo.data.net.ServiceCreator
import ph.com.globe.gomo.data.net.api.ApiService
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