package ph.com.globe.data.network

import ph.com.globe.data.network.profile.GomoProfileService

interface NetworkService {
    fun getProfileNetworkService(): GomoProfileService
}
