package ph.com.globe.data.network

import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException
import ph.com.globe.data.network_components.NetworkStatusProvider
import ph.com.globe.model.network.NetworkConnectionStatus

class ConnectivityInterceptor(private val networkStatusProvider: NetworkStatusProvider) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        when (networkStatusProvider.provideNetworkConnectionStatus()) {
            NetworkConnectionStatus.NotConnectedToInternet -> throw NoInternet
            else -> return chain.proceed(chain.request())
        }
    }
}

object NoInternet : IOException()
