package com.wednesday.bankingdetails.utility

import java.util.*

class Utils {
    companion object {
        fun capitalizeFirstLetter(string: String) =
                string.split(" ").joinToString(" ") { it.capitalize(Locale.getDefault()) }
                        .trimEnd()
    }
}