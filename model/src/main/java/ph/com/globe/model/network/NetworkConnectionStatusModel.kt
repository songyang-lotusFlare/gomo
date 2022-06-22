package ph.com.globe.model.network

sealed class NetworkConnectionStatus {
    object ConnectedToMobileData : NetworkConnectionStatus()
    object ConnectedToWifi : NetworkConnectionStatus()
    object NotConnectedToInternet : NetworkConnectionStatus()
    object Other : NetworkConnectionStatus()
}
