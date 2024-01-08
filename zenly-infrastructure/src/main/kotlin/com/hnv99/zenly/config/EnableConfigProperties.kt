package com.hnv99.zenly.config

import com.hnv99.zenly.config.s3.S3Properties
import com.hnv99.zenly.config.slack.SlackProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@EnableConfigurationProperties(MongoDBProperties::class, SlackProperties::class, OauthProperties::class, S3Properties::class)
@Configuration
class EnableConfigProperties