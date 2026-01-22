package com.org.janitri.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.org.janitri.util.NotificationHelper
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class VitalsReminderWorker @AssistedInject constructor(
    @Assisted ctx: Context,
    @Assisted params: WorkerParameters
) : Worker(ctx, params) {

    override fun doWork(): Result {
        NotificationHelper.show(applicationContext)
        return Result.success()
    }
}
