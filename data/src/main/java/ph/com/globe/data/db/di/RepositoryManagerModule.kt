package ph.com.globe.data.db.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ph.com.globe.data.db.IRepositoryManager
import ph.com.globe.data.db.RepositoryManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryManagerModule {
    @Binds
    @Singleton
    fun bindRepoManager(repositoryManager: RepositoryManager): IRepositoryManager
}
