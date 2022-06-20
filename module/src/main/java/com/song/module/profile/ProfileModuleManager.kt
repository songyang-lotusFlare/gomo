package com.song.module.profile

import com.song.common.LfResult
import com.song.common.errors.profile.GetGomoUserError
import com.song.model.profile.domin_models.GomoUserModel
import com.song.module.profile.usecase.GomoUserUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//Finally injected into the app layer class
class ProfileModuleManager @Inject constructor(
    //useCase ...
    private val gomoUserUseCase: GomoUserUseCase
) {

    suspend fun getGomoUserCase(): Flow<LfResult<GomoUserModel?, GetGomoUserError>> = gomoUserUseCase.execute()

}