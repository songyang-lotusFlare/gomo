package ph.com.globe.data.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ph.com.globe.data.network.NetworkService
import ph.com.globe.data.network.NetworkServices
import ph.com.globe.data.network.profile.GomoProfileService
import ph.com.globe.data.network.profile.GomoProfileServiceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface NetworkServiceModule {
    //manager Service
    @Singleton
    @Binds
    abstract fun providerNetworkService(networkServices: NetworkServices): NetworkService

    //other Services
    @Singleton
    @Binds
    fun providerProfileService(gomoProfileService: GomoProfileServiceImpl): GomoProfileService
}
