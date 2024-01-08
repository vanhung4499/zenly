package com.hnv99.zenly.exception.custom

import com.hnv99.zenly.exception.GlobalErrorCode
import com.hnv99.zenly.exception.ZenlyCodeException

class RefreshTokenExpiredException : ZenlyCodeException(
    GlobalErrorCode.REFRESH_TOKEN_EXPIRED,
) {
    companion object {
        val EXCEPTION: ZenlyCodeException = RefreshTokenExpiredException()
    }
}