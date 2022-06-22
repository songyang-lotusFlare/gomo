package ph.com.globe.domain.profile.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ph.com.globe.domain.profile.IProfileDomainManager
import ph.com.globe.domain.profile.ProfileDomainManager

@Module
@InstallIn(SingletonComponent::class)
internal interface ProfileDomainModule {
    @Binds
    fun providerProfileDomainManager(profileDomainManager: ProfileDomainManager): IProfileDomainManager
}
