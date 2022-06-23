package ph.com.globe.domain.profile

import ph.com.globe.model.profile.domain_models.GomoUser
import ph.com.globe.domain.profile.usecase.GomoUserUseCase
import kotlinx.coroutines.flow.Flow
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.domain.profile.usecase.GomoUserUpdateUseCase
import ph.com.globe.model.profile.response_models.GetGomoUserParams
import javax.inject.Inject

//Finally injected into the app layer class
internal class ProfileDomainManagerImpl @Inject constructor(
    //useCase ...
    private val gomoUserUseCase: GomoUserUseCase,
    private val updateUseCase: GomoUserUpdateUseCase
) : ProfileDomainManager {
    override suspend fun getGomoUser(): Flow<LfResult<GomoUser?, GetGomoUserError>> =
        gomoUserUseCase.execute()

    override suspend fun updateAndGetUser(param: GetGomoUserParams): Flow<LfResult<GomoUser, GetGomoUserError>> =
        updateUseCase.execute(param)

}
