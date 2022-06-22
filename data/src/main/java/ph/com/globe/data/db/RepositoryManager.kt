package ph.com.globe.data.db

import ph.com.globe.data.db.profile_info.GomoUserDataRepository

interface RepositoryManager {
    fun getGomoUserDataRepo(): GomoUserDataRepository
}
