package ph.com.globe.data.network.profile.calls

import ph.com.globe.data.network.profile.ProfileApiService
import ph.com.globe.data.network.utils.toLFSdkResult
import ph.com.globe.data.network.utils.toLfSdkResult
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.GeneralError
import ph.com.globe.common.errors.NetworkError
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.common.fold
import ph.com.globe.model.profile.response_models.GetGomoUserParams
import ph.com.globe.model.profile.response_models.GetGomoUserResponse
import ph.com.globe.model.profile.response_models.GetGomoUserResult
import ph.com.globe.model.profile.response_models.toQueryMap
import retrofit2.Response
import javax.inject.Inject

class GetGomoUserCall @Inject constructor(
    private val profileApiService: ProfileApiService
) {

    suspend fun execute(params: GetGomoUserParams): LfResult<GetGomoUserResult, GetGomoUserError> {

        //get headMap
        val headerMap = mapOf<String, String>()

        val response = kotlin.runCatching {
            profileApiService.getGomoUser(headerMap = headerMap,
                params.toQueryMap()
            )
        }.fold(Response<GetGomoUserResponse>::toLfSdkResult, Throwable::toLFSdkResult)

        return response.fold(
            {LfResult.success(it.result)},
            {LfResult.failure(it.toSpecific())}
        )
    }

}
private fun NetworkError.toSpecific(): GetGomoUserError = GetGomoUserError.General(
    GeneralError.Other(
        this
    )
)