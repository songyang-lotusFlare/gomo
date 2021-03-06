package ph.com.globe.data.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import ph.com.globe.data.network.ConnectivityInterceptor
import ph.com.globe.data.network.DemoInterceptor
import ph.com.globe.data.network.profile.ProfileApiService
import ph.com.globe.data.network_components.NetworkStatusProvider
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

//Define different OkHttp qualifier
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindOneOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindTwoOkHttpClient


//Define different Retrofit qualifier
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindOneRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindTwoRetrofit


@Module
@InstallIn(SingletonComponent::class)
internal class NetWorkModule {
    @Singleton
    @Provides
    fun provideConnectivityInterceptor(networkStatusProvider: NetworkStatusProvider): ConnectivityInterceptor =
        ConnectivityInterceptor(networkStatusProvider)

    //Interceptor
    @Singleton
    @Provides
    fun providerDemoInterceptor(): DemoInterceptor =
        DemoInterceptor()

    //Define different OkHttp implementations

    @Singleton
    @Provides
    @BindOneOkHttpClient
    fun providerOneOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Singleton
    @Provides
    @BindTwoOkHttpClient
    fun providerTwoOkHttpClient(demoInterceptor: DemoInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(demoInterceptor)
            .build()

    //Define different Retrofit implementations

    @Singleton
    @Provides
    @BindOneRetrofit
    fun providerOneRetrofit(@BindOneOkHttpClient okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL.BASE_URL)
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    @BindTwoRetrofit
    fun providerTwoRetrofit(@BindTwoOkHttpClient okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL.SECOND_URL)
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun providerProfileApiService(@BindOneRetrofit retrofit: Retrofit): ProfileApiService =
        retrofit.create(ProfileApiService::class.java)

}

object URL {
    const val BASE_URL: String = "http://www.gomo.com"
    const val SECOND_URL: String = "http://www.gomo1.com"
}

