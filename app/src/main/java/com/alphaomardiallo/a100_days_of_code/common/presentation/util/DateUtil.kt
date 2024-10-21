package com.alphaomardiallo.a100_days_of_code.common.presentation.util

import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun longToFormattedDate(timestamp: Long): String {
    val date = Date(timestamp)
    val locale = Locale.getDefault()
    val format =
        SimpleDateFormat(if (locale.country == "us") "MM/dd/yyyy" else "dd/MM/yyyy", locale)
    return try {
        format.format(date)
    } catch (e: Exception) {
        Timber.e(e.localizedMessage)
        ""
    }
}
