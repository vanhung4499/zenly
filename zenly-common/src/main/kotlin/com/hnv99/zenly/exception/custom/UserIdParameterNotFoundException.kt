package com.hnv99.zenly.exception.custom

import com.hnv99.zenly.exception.GlobalErrorCode
import com.hnv99.zenly.exception.ZenlyCodeException

class UserIdParameterNotFoundException : ZenlyCodeException(
    GlobalErrorCode.USER_ID_PARAMETER_NOT_FOUND,
) {
    companion object {
        val EXCEPTION: ZenlyCodeException = UserIdParameterNotFoundException()
    }
}