package ph.com.globe.gomo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ph.com.globe.gomo.data.database.AppDatabase
import ph.com.globe.gomo.data.database.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providerAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providerUserDao(database: AppDatabase) : UserDao {
        return database.userDao()
    }

}