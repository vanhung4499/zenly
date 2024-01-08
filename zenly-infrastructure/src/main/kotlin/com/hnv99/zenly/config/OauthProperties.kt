package com.hnv99.zenly.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "oauth")
@ConstructorBinding
class OauthProperties(
    val google: OathSecret,
) {
    data class OathSecret(
        val clientId: String,
        val clientSecret: String,
    )
}