package ph.com.globe.domain.profile

import kotlinx.coroutines.flow.Flow
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.model.profile.domain_models.GomoUser
import ph.com.globe.model.profile.response_models.GetGomoUserParams

interface ProfileDomainManager {
    suspend fun getGomoUser(): Flow<LfResult<GomoUser?, GetGomoUserError>>
    suspend fun updateAndGetUser(param: GetGomoUserParams): Flow<LfResult<GomoUser, GetGomoUserError>>
}
