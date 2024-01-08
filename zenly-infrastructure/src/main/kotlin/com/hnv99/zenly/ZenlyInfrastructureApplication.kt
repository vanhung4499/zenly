package com.hnv99.zenly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZenlyInfrastructureApplication

fun main(args: Array<String>) {
    runApplication<ZenlyInfrastructureApplication>(*args)
}