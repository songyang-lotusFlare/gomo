package ph.com.globe.data.network

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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

}

object URL{
    const val BASE_URL: String = "www.gomo.com"
    const val SECOND_URL: String = "www.gomo1.com"
}

