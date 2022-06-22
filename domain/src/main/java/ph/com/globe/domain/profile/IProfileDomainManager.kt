package ph.com.globe.domain.profile

import kotlinx.coroutines.flow.Flow
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.model.profile.domin_models.GomoUserModel

interface IProfileDomainManager {
    suspend fun getGomoUserCase(): Flow<LfResult<GomoUserModel?, GetGomoUserError>>
}
