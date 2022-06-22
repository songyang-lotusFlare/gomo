package ph.com.globe.data.network_components

import ph.com.globe.model.network.NetworkConnectionStatus
import javax.inject.Inject

internal class ConnectivityManager @Inject constructor(
    private val networkStatusProvider: NetworkStatusProvider
) : IConnectivityManager {
    override fun getNetworkStatus(): NetworkConnectionStatus =
        networkStatusProvider.provideNetworkConnectionStatus()
}
