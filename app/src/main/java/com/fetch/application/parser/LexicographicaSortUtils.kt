package com.fetch.application.parser

import java.util.regex.Pattern

fun extractNumericValue(name: String?): Int {
    return if (name != null) {
        val matcher = Pattern.compile("\\d+").matcher(name)
        if (matcher.find()) {
            matcher.group().toInt()
        } else {
            Int.MAX_VALUE
        }
    } else {
        Int.MAX_VALUE
    }
}