package com.alphaomardiallo.a100_days_of_code.common.domain.validator

import java.util.regex.Pattern

object PasswordValidator {

    private const val PASSWORD_REGEX_PATTERN =
        "^(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$"

    fun isValidPassword(password: String): Boolean {
        val pattern = Pattern.compile(PASSWORD_REGEX_PATTERN)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }
}
