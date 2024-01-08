package com.hnv99.zenly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ZenlyCommonApplication

fun main(args: Array<String>) {
    runApplication<ZenlyCommonApplication>(*args)
}