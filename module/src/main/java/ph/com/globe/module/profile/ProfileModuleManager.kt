package ph.com.globe.module.profile

import ph.com.globe.model.profile.domin_models.GomoUserModel
import ph.com.globe.module.profile.usecase.GomoUserUseCase
import kotlinx.coroutines.flow.Flow
import ph.com.globe.common.LfResult
import ph.com.globe.common.errors.profile.GetGomoUserError
import javax.inject.Inject

//Finally injected into the app layer class
class ProfileModuleManager @Inject constructor(
    //useCase ...
    private val gomoUserUseCase: GomoUserUseCase
) {

    suspend fun getGomoUserCase(): Flow<LfResult<GomoUserModel?, GetGomoUserError>> = gomoUserUseCase.execute()
}
