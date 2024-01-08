package com.hnv99.zenly.config.s3

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "s3")
@ConstructorBinding
data class S3Properties(
    val s3: S3Secret,
) {
    data class S3Secret(
        val accessKey: String,
        val secretKey: String,
        val region: String,
        val endpoint: String,
        val bucket: String,
    )
}
