package ph.com.globe.data.network

import ph.com.globe.data.network.profile.IGomoUserService

interface INetworkService {

    fun getProfileNetworkService(): IGomoUserService
}
