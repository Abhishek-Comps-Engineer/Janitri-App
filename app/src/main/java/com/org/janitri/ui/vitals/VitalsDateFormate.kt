package com.org.janitri.ui.vitals

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatTimestamp(timestamp: Long): String {
    val sdf = SimpleDateFormat("EEE, dd MMM yyyy hh:mm a", Locale.getDefault())
    return sdf.format(Date(timestamp))
}
