package ph.com.globe.domain.profile.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ph.com.globe.domain.profile.ProfileDomainManager
import ph.com.globe.domain.profile.ProfileDomainManagerImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface ProfileDomainModule {
    @Binds
    fun providerProfileDomainManager(profileDomainManager: ProfileDomainManagerImpl): ProfileDomainManager
}
