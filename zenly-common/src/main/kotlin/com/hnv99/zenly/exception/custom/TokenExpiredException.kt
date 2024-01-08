package com.hnv99.zenly.exception.custom

import com.hnv99.zenly.exception.GlobalErrorCode
import com.hnv99.zenly.exception.ZenlyCodeException

class TokenExpiredException : ZenlyCodeException(
    GlobalErrorCode.TOKEN_EXPIRED,
) {
    companion object {
        val EXCEPTION: ZenlyCodeException = TokenExpiredException()
    }
}