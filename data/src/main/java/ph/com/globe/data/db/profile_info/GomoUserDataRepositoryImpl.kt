package ph.com.globe.data.db.profile_info

import ph.com.globe.model.profile.domin_models.GomoUserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.data.network.profile.GomoProfileService
import ph.com.globe.model.profile.response_models.GetGomoUserParams
import ph.com.globe.model.profile.response_models.GetGomoUserResult
import javax.inject.Inject

internal class GomoUserDataRepositoryImpl @Inject constructor(
    private val gomoUserQueryDao: GomoUserQueryDao,
    private val gomoUserDataUpdater: GomoUserDataUpdater,
    private val gomoProfileService: GomoProfileService
) : GomoUserDataRepository {
    override suspend fun fetchUpdateAndGet(param: GetGomoUserParams): LfResult<GetGomoUserResult, GetGomoUserError> =
        gomoUserDataUpdater.update(param, { gomoProfileService.getGomoUser(it) }) {
            gomoUserQueryDao.clearAndInsert(it.toEntity())
        }!!//todo: Need to get rid of !!

    //todo: need update method
    override suspend fun getGomoUser(): Flow<GomoUserModel> =
        gomoUserQueryDao.getAllUser().map { it.toDomain() }


    //todo: more method for demand
}
