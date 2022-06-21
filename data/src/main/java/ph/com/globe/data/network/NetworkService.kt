package ph.com.globe.data.network

import ph.com.globe.data.network.profile.GomoProfileService
import javax.inject.Inject

internal class NetworkServices @Inject constructor(
    private val profileManager: GomoProfileService
): INetworkService {

    override fun getProfileNetworkService(): GomoProfileService = profileManager
}
