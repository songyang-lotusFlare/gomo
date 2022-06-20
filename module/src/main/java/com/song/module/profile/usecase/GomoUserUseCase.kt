/*
 * Copyright (C) 2021 LotusFlare
 * All Rights Reserved.
 * Unauthorized copying and distribution of this file, via any medium is strictly prohibited.
 */

package com.song.module.profile.usecase

import com.song.common.LfResult
import com.song.common.errors.profile.GetGomoUserError
import com.song.model.profile.domin_models.GomoUserModel
import com.song.module.IDataManagers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import javax.inject.Inject


class GomoUserUseCase @Inject constructor(repoManager: IDataManagers) {

    private val gomoUserRepo = repoManager.getGomoUserDataRepo()

//    suspend fun execute(): Flow<LfResult<GomoUserModel?, GetGomoUserError>> =
//        gomoUserRepo.getGomoUser()getGomoUser

}
