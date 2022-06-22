package ph.com.globe.data.db

import ph.com.globe.data.db.profile_info.GomoUserDataRepository
import ph.com.globe.data.db.profile_info.IGomoUserDataRepository

interface IRepositoryManager {
    fun getGomoUserDataRepo(): IGomoUserDataRepository
}
