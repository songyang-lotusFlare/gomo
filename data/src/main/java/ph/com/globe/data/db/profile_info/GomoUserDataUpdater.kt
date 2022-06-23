package ph.com.globe.data.db.profile_info

import ph.com.globe.common.errors.profile.GetGomoUserError
import ph.com.globe.data.db.updater.ParameterizedDataUpdater
import ph.com.globe.model.profile.response_models.GetGomoUserParams
import ph.com.globe.model.profile.response_models.GetGomoUserResult
import javax.inject.Inject

class GomoUserDataUpdater @Inject constructor() :
    ParameterizedDataUpdater<GetGomoUserParams, GetGomoUserResult, GetGomoUserError>()
