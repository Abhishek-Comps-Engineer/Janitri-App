package com.org.janitri.util

import com.org.janitri.notification.NavigationKeys
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.org.janitri.MainActivity

object NotificationHelper {

    fun show(context: Context) {

        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("pregnancyvitals://log"),
            context,
            MainActivity::class.java
        ).apply {
            putExtra(NavigationKeys.OPEN_ADD, true)
            flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TOP
        }

        val pending = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or
                    PendingIntent.FLAG_IMMUTABLE
        )

        val channelId = "vitals"

        if (Build.VERSION.SDK_INT >= 26) {
            context.getSystemService(NotificationManager::class.java)
                .createNotificationChannel(
                    NotificationChannel(
                        channelId,
                        "Vitals",
                        NotificationManager.IMPORTANCE_DEFAULT
                    )
                )
        }

        val notification =
            NotificationCompat.Builder(context, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Time to log your vitals!")
                .setContentText(
                    "Stay on top of your health. Please update your vitals now!"
                )
                .setContentIntent(pending)
                .setAutoCancel(true)
                .build()

        NotificationManagerCompat
            .from(context)
            .notify(1001, notification)
    }
}
