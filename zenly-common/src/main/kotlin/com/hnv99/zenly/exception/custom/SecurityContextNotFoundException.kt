package com.hnv99.zenly.exception.custom

import com.hnv99.zenly.exception.GlobalErrorCode
import com.hnv99.zenly.exception.ZenlyCodeException

class SecurityContextNotFoundException : ZenlyCodeException(
    GlobalErrorCode.SECURITY_CONTEXT_NOT_FOUND,
) {
    companion object {
        val EXCEPTION: ZenlyCodeException = SecurityContextNotFoundException()
    }
}