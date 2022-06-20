package ph.com.globe.common.errors.profile

import ph.com.globe.common.errors.GeneralError


sealed class GetGomoUserError {
    data class General(val err: GeneralError): GetGomoUserError()
}