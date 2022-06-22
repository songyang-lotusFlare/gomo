package ph.com.globe.data.db.profile_info

import ph.com.globe.model.profile.domin_models.GomoUserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GomoUserDataRepositoryImpl @Inject constructor(
    private val gomoUserQueryDao: GomoUserQueryDao
    //todo: add network(manager) para to implement update between net and database
) : GomoUserDataRepository {
    //todo: need update method
    override suspend fun getGomoUser(): Flow<GomoUserModel> =
        gomoUserQueryDao.getAllUser().map { it?.toDomain() }

    //todo: more method for demand
}
