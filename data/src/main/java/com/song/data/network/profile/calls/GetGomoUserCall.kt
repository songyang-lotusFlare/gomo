package com.song.data.network.profile.calls

import com.song.common.LfResult
import com.song.common.errors.GeneralError
import com.song.common.errors.NetworkError
import com.song.common.errors.profile.GetGomoUserError
import com.song.common.fold
import com.song.data.network.profile.ProfileApiService
import com.song.data.network.utils.toLFSdkResult
import com.song.data.network.utils.toLfSdkResult
import com.song.model.profile.response_models.GetGomoUserParams
import com.song.model.profile.response_models.GetGomoUserResponse
import com.song.model.profile.response_models.GetGomoUserResult
import com.song.model.profile.response_models.toQueryMap
import retrofit2.Response
import retrofit2.http.HEAD
import javax.inject.Inject

class GetGomoUserCall @Inject constructor(
    private val profileApiService: ProfileApiService
) {

    suspend fun execute(params: GetGomoUserParams): LfResult<GetGomoUserResult, GetGomoUserError> {

        //get headMap
        val headerMap = mapOf<String, String>()

        val response = kotlin.runCatching {
            profileApiService.getGomoUser(headerMap = headerMap, params.toQueryMap())
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