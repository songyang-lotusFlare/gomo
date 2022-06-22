package ph.com.globe.data.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ph.com.globe.data.network.NetworkService
import ph.com.globe.data.network.NetworkServices
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface NetworkServiceModule {
    //manager
    @Singleton
    @Binds
    abstract fun providerNetworkService(networkServices: NetworkServices): NetworkService
}
