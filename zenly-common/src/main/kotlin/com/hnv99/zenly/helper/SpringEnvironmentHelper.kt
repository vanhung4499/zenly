package com.hnv99.zenly.helper

import com.hnv99.zenly.annotation.Helper
import com.hnv99.zenly.consntants.DEV
import com.hnv99.zenly.consntants.LOCAL
import com.hnv99.zenly.consntants.PROD
import org.springframework.core.env.Environment
import org.springframework.util.CollectionUtils

@Helper
class SpringEnvironmentHelper(
    val environment: Environment,
) {

    private val PROD_AND_DEV = listOf(DEV, PROD)
    val isProdProfile: Boolean
        get() {
            val activeProfiles = environment.activeProfiles.toList()
            return activeProfiles.contains(PROD)
        }
    val isLocalProfile: Boolean
        get() {
            return environment.activeProfiles.contains(LOCAL)
        }
    val isDevProfile: Boolean
        get() {
            return environment.activeProfiles.contains(DEV)
        }
    val isProdAndDevProfile: Boolean
        get() {
            val activeProfiles = environment.activeProfiles.toList()
            return CollectionUtils.containsAny(PROD_AND_DEV, activeProfiles)
        }
    val activeProfile: String
        get() {
            if (isProdProfile) return PROD
            if (isDevProfile) return DEV
            return LOCAL
        }
}
