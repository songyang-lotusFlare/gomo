package ph.com.globe.data.network

import ph.com.globe.data.network.profile.GomoProfileService
import javax.inject.Inject

class NetworkServices @Inject constructor(

    private val profileManager: GomoProfileService
) {

    fun getProfileNetworkRepo(): GomoProfileService = profileManager
}