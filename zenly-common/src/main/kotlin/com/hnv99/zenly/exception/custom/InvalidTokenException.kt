package com.hnv99.zenly.exception.custom

import com.hnv99.zenly.exception.GlobalErrorCode
import com.hnv99.zenly.exception.ZenlyCodeException

class InvalidTokenException : ZenlyCodeException(
    GlobalErrorCode.INVALID_TOKEN,
) {
    companion object {
        val EXCEPTION: ZenlyCodeException = InvalidTokenException()
    }
}