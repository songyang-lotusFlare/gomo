package ph.com.globe.domain.profile.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.common.fold
import ph.com.globe.common.onSuccess
import ph.com.globe.data.db.RepositoryManager
import ph.com.globe.data.db.profile_info.toEntity
import ph.com.globe.model.profile.domin_models.GomoUserModel
import ph.com.globe.model.profile.response_models.GetGomoUserParams
import ph.com.globe.model.profile.response_models.GetGomoUserResult
import ph.com.globe.model.profile.response_models.toModel
import javax.inject.Inject

internal class GomoUserUpdateUseCase @Inject constructor(
    repoManager: RepositoryManager
) {
    private val gomoUserRepo = repoManager.getGomoUserDataRepo()

    suspend fun execute(params: GetGomoUserParams): Flow<LfResult<GomoUserModel, GetGomoUserError>> =
        gomoUserRepo.fetchUpdateAndGet(params).let { it ->
            it.fold(
                {
                    flowOf(LfResult.success(it.toModel()))
                },
                {
                    flowOf(LfResult.failure(it))
                },

                )
        }
}
