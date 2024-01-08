package com.hnv99.zenly.exception.custom

import com.hnv99.zenly.exception.GlobalErrorCode
import com.hnv99.zenly.exception.ZenlyCodeException

class UserIdConversionException : ZenlyCodeException(
    GlobalErrorCode.USER_ID_NOT_LONG,
) {
    companion object {
        val EXCEPTION: ZenlyCodeException = UserIdConversionException()
    }
}