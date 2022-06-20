package com.song.data.network.profile

import com.song.common.LfResult
import com.song.common.errors.profile.GetGomoUserError
import com.song.data.network.profile.calls.GetGomoUserCall
import com.song.model.profile.response_models.GetGomoUserParams
import com.song.model.profile.response_models.GetGomoUserResponse
import com.song.model.profile.response_models.GetGomoUserResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GomoProfileService @Inject constructor(
    private val getGomoUserCall: GetGomoUserCall
){

     suspend fun getGomoUser(params: GetGomoUserParams): LfResult<GetGomoUserResult, GetGomoUserError> =
        withContext(Dispatchers.IO) {
            getGomoUserCall.execute(params)
        }
}