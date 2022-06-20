package ph.com.globe.data.db.profile_info

import ph.com.globe.model.profile.domin_models.GomoUserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GomoUserDataRepository @Inject constructor(
    private val gomoUserQueryDao: GomoUserQueryDao
    //todo: add network(manager) para to implement update between net and database
) {

    //todo: need update method

    suspend fun getGomoUser(): Flow<GomoUserModel> =
        gomoUserQueryDao.getAllUser().map { it?.toDomain() }

    //todo: more method for demand
}