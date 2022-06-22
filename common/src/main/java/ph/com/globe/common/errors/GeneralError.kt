package ph.com.globe.common.errors

sealed class GeneralError {
    object NotLoggedIn: GeneralError()
    object General: GeneralError()
    data class Other(val error: NetworkError): GeneralError()
}