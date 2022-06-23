package ph.com.globe.domain.profile.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.common.fold
import ph.com.globe.data.db.RepositoryManager
import ph.com.globe.model.profile.domain_models.GomoUser
import ph.com.globe.model.profile.response_models.GetGomoUserParams
import ph.com.globe.model.profile.response_models.toUserDomain
import javax.inject.Inject

internal class GomoUserUpdateUseCase @Inject constructor(
    repoManager: RepositoryManager
) {
    private val gomoUserRepo = repoManager.getGomoUserDataRepo()

    suspend fun execute(params: GetGomoUserParams): Flow<LfResult<GomoUser, GetGomoUserError>> =
        gomoUserRepo.fetchUpdateAndGet(params).let { it ->
            it.fold(
                {
                    flowOf(LfResult.success(it.toUserDomain()))
                },
                {
                    flowOf(LfResult.failure(it))
                },

                )
        }
}
