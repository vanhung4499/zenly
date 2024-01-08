package com.hnv99.zenly.exception

import com.hnv99.zenly.dto.ErrorReason

interface BaseErrorCode {
    val errorReason: ErrorReason

    val explainError: String
}