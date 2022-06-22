package ph.com.globe.data.network

import ph.com.globe.data.network.profile.GomoProfileServiceImpl
import javax.inject.Inject

internal class NetworkServices @Inject constructor(
    private val profileManager: GomoProfileServiceImpl
) : NetworkService {
    override fun getProfileNetworkService(): GomoProfileServiceImpl = profileManager
}
