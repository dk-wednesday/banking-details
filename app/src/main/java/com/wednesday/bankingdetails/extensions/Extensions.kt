package com.wednesday.bankingdetails.extensions

import java.util.*

fun String.capitalizeFirstLetter(): String =
    this.split(" ").joinToString(" ") { it.capitalize(Locale.getDefault()) }
        .trimEnd()

class Extensions {
}