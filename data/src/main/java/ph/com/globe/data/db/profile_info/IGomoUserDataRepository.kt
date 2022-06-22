package ph.com.globe.data.db.profile_info

import kotlinx.coroutines.flow.Flow
import ph.com.globe.model.profile.domin_models.GomoUserModel

interface IGomoUserDataRepository {
    suspend fun getGomoUser(): Flow<GomoUserModel>
}
