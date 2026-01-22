package com.org.janitri.util

import android.content.Intent
import com.org.janitri.notification.NavigationKeys

object NavigationResolver {

    fun shouldOpenAddVitals(intent: Intent?): Boolean {
        if (intent == null) return false

        if (intent.getBooleanExtra(
                NavigationKeys.OPEN_ADD,
                false
            )
        ) return true

        val uri = intent.data
        return uri?.scheme == "pregnancyvitals" &&
                uri.host == "log"
    }
}
