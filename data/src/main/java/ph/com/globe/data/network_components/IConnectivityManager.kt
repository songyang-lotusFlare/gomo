package ph.com.globe.data.network_components

import ph.com.globe.model.network.NetworkConnectionStatus

interface IConnectivityManager {
    fun getNetworkStatus(): NetworkConnectionStatus
}
