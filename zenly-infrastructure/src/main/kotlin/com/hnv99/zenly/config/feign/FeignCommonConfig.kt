package com.hnv99.zenly.config.feign

import com.hnv99.zenly.api.BaseFeignClientPackage
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackageClasses = [BaseFeignClientPackage::class])
class FeignCommonConfig {
    @Bean
    fun feignLoggerLevel(): feign.Logger.Level {
        return feign.Logger.Level.FULL
    }
}