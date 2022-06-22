package ph.com.globe.data.network_components.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ph.com.globe.data.network_components.DefaultNetworkStatusProvider
import ph.com.globe.data.network_components.NetworkStatusProvider

@Module
@InstallIn(SingletonComponent::class)
internal interface NetworkStatusModule {
    @Binds
    fun bindNetworkStateProvider(defaultNetworkStatusProvider: DefaultNetworkStatusProvider): NetworkStatusProvider
}
