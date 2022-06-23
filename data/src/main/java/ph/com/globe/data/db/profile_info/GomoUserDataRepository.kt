package ph.com.globe.data.db.profile_info

import kotlinx.coroutines.flow.Flow
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.model.profile.domin_models.GomoUserModel
import ph.com.globe.model.profile.response_models.GetGomoUserParams
import ph.com.globe.model.profile.response_models.GetGomoUserResult

interface GomoUserDataRepository {
    suspend fun fetchUpdateAndGet(param: GetGomoUserParams): LfResult<GetGomoUserResult, GetGomoUserError>
    suspend fun getGomoUser(): Flow<GomoUserModel>
}
