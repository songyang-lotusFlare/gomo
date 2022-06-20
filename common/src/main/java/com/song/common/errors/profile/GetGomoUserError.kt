package com.song.common.errors.profile

import com.song.common.errors.GeneralError

sealed class GetGomoUserError {
    data class General(val err: GeneralError): GetGomoUserError()
}