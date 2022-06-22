package ph.com.globe.domain.profile

import ph.com.globe.model.profile.domin_models.GomoUserModel
import ph.com.globe.domain.profile.usecase.GomoUserUseCase
import kotlinx.coroutines.flow.Flow
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import javax.inject.Inject

//Finally injected into the app layer class
internal class ProfileDomainManagerImpl @Inject constructor(
    //useCase ...
    private val gomoUserUseCase: GomoUserUseCase
) : ProfileDomainManager {
    override suspend fun getGomoUserCase(): Flow<LfResult<GomoUserModel?, GetGomoUserError>> =
        gomoUserUseCase.execute()
}

