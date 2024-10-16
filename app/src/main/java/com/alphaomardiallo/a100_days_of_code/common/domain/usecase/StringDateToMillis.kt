package com.alphaomardiallo.a100_days_of_code.common.domain.usecase

import java.text.SimpleDateFormat
import java.util.Locale

class StringDateToMillis {

    fun invoke(date: String): Long {
        val dateFormat = SimpleDateFormat(isUSLocale(), Locale.getDefault())
        return try {
            dateFormat.parse(date)?.time ?: 0L
        } catch (e: Exception) {
            0L
        }
    }

    private fun isUSLocale(locale: Locale = Locale.getDefault()): String {
        return if (locale.country == "US") {
            "MM/dd/yyyy"
        } else {
            "dd/MM/yyyy"
        }
    }
}
