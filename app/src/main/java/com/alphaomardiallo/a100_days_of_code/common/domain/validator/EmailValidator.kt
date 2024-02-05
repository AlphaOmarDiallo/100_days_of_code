package com.alphaomardiallo.a100_days_of_code.common.domain.validator

import java.util.regex.Pattern

object EmailValidator {

    private const val EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"

    fun isValidEmail(email: String): Boolean {
        val pattern = Pattern.compile(EMAIL_REGEX_PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}
