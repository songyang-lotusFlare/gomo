package ph.com.globe.data.db.updater

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import ph.com.globe.common.LfResult

open class ParameterlessDataUpdater<R, E> {

    var isUpdateOngoing = false
        private set
    private val mutex = Mutex()

    suspend fun update(
        networkCall: suspend () -> LfResult<R, E>,
        dbCall: suspend (R) -> Unit
    ): LfResult<R, E>? {
        if (!isUpdateOngoing) {
            mutex.withLock {
                if (!isUpdateOngoing) {
                    isUpdateOngoing = true
                    val result = try {
                        networkCall.invoke()
                    } catch (e: Exception) {
                        isUpdateOngoing = false
                        throw e
                    }
                    result.successOrNull()?.let {
                        dbCall.invoke(it)
                    } ?: run {
                        isUpdateOngoing = false
                        return result
                    }
                    return result

                }
            }
        }
        return null
    }
}
