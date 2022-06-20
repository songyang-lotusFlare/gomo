package ph.com.globe.data.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * All Interceptors
 */
internal class DemoInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //TODO("Not yet implemented")
        return chain.proceed(request = chain.request())
    }
}