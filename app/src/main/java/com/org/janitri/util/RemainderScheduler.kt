package com.org.janitri.util

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.org.janitri.worker.VitalsReminderWorker
import java.util.concurrent.TimeUnit

object ReminderScheduler {

    fun schedule(context: Context) {
        val request =
            PeriodicWorkRequestBuilder<VitalsReminderWorker>(
                5, TimeUnit.HOURS
            ).build()

        WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork(
                "vitals_reminder",
                ExistingPeriodicWorkPolicy.KEEP,
                request
            )
    }
}
