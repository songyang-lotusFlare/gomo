package ph.com.globe.data.db

import ph.com.globe.data.db.profile_info.GomoUserDataRepositoryImpl
import javax.inject.Inject

internal class RepositoryManagerImpl @Inject constructor(
    private val gomoUserRepository: GomoUserDataRepositoryImpl
    //todo: add more Dao
) : RepositoryManager {
    override fun getGomoUserDataRepo(): GomoUserDataRepositoryImpl = gomoUserRepository
}
