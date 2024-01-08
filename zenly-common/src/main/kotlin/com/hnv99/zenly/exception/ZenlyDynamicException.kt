package com.hnv99.zenly.exception

class ZenlyDynamicException (
    val status: Int,
    val code: String,
    val reason: String?,
) : RuntimeException()