package ph.com.globe.data.db.di

import ph.com.globe.data.db.profile_info.GomoUserDataRepository
import javax.inject.Inject

class RepositoryManager @Inject constructor(
    private val gomoUserRepository: GomoUserDataRepository
    //todo: add more Dao
){

    fun getGomoUserDataRepo(): GomoUserDataRepository = gomoUserRepository
}