package ph.com.globe.data.db

import ph.com.globe.data.db.IRepositoryManager
import ph.com.globe.data.db.profile_info.GomoUserDataRepository
import javax.inject.Inject

internal class RepositoryManager @Inject constructor(
    private val gomoUserRepository: GomoUserDataRepository
    //todo: add more Dao
) : IRepositoryManager {
    override fun getGomoUserDataRepo(): GomoUserDataRepository = gomoUserRepository
}
