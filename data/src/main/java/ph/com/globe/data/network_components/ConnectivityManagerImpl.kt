package ph.com.globe.data.network_components

import ph.com.globe.model.network.NetworkConnectionStatus
import javax.inject.Inject

internal class ConnectivityManagerImpl @Inject constructor(
    private val networkStatusProvider: NetworkStatusProvider
) : ConnectivityManager {
    override fun getNetworkStatus(): NetworkConnectionStatus =
        networkStatusProvider.provideNetworkConnectionStatus()
}
