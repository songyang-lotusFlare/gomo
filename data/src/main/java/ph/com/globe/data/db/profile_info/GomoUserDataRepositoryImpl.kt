package ph.com.globe.data.db.profile_info

import ph.com.globe.model.profile.domain_models.GomoUser
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
            gomoUserQueryDao.clearAndInsert(it.toUserEntity())
        }!!//todo: Need to get rid of !!

    //todo: need update method
    override suspend fun getGomoUser(): Flow<GomoUser> =
        gomoUserQueryDao.getAllUser().map { it.toUserDomain() }

    //todo: more method for demand
}
