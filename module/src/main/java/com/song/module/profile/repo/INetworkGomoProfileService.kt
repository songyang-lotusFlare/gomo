package com.song.module.profile.repo

import com.song.common.LfResult
import com.song.common.errors.profile.GetGomoUserError
import com.song.model.profile.response_models.GetGomoUserParams
import com.song.model.profile.response_models.GetGomoUserResult

interface INetworkGomoProfileService {

    suspend fun getGomoUser(params: GetGomoUserParams): LfResult<GetGomoUserResult, GetGomoUserError>
}