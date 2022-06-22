package ph.com.globe.data.network.profile

import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.model.profile.response_models.GetGomoUserParams
import ph.com.globe.model.profile.response_models.GetGomoUserResult

interface GomoProfileService {
    suspend fun getGomoUser(params: GetGomoUserParams): LfResult<GetGomoUserResult, GetGomoUserError>
}
