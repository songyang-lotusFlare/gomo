/*
 * Copyright (C) 2021 LotusFlare
 * All Rights Reserved.
 * Unauthorized copying and distribution of this file, via any medium is strictly prohibited.
 */

package ph.com.globe.domain.profile.usecase

import ph.com.globe.model.profile.domin_models.GomoUserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.data.db.IRepositoryManager
import javax.inject.Inject

internal class GomoUserUseCase @Inject constructor(repoManager: IRepositoryManager) {
    private val gomoUserRepo = repoManager.getGomoUserDataRepo()

    suspend fun execute(): Flow<LfResult<GomoUserModel?, GetGomoUserError>> =
        gomoUserRepo.getGomoUser().map {
            LfResult.success(it)
        }
}

