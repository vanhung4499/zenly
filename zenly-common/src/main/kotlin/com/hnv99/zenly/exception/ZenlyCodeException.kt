package com.hnv99.zenly.exception

import com.hnv99.zenly.dto.ErrorReason

open class ZenlyCodeException (
    val errorCode: BaseErrorCode,
) : RuntimeException() {

    val errorReason: ErrorReason
        get() {
            return errorCode.errorReason
        }
}