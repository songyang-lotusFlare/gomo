package ph.com.globe.data.network.profile

import ph.com.globe.data.network.profile.calls.GetGomoUserCall
import ph.com.globe.model.profile.response_models.GetGomoUserParams
import ph.com.globe.model.profile.response_models.GetGomoUserResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import javax.inject.Inject

internal class GomoProfileService @Inject constructor(
    private val getGomoUserCall: GetGomoUserCall
) : IGomoUserService {
    override suspend fun getGomoUser(params: GetGomoUserParams): LfResult<GetGomoUserResult, GetGomoUserError> =
        withContext(Dispatchers.IO) {
            getGomoUserCall.execute(params)
        }
}
