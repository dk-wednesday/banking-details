package com.wednesday.bankingdetails.utility

import java.util.*

class Utils {
    companion object {
        public fun capitalizeFirstLetter(string: String) =
            string.split(" ").joinToString(" ") { it.capitalize(Locale.getDefault()) }
                .trimEnd()
    }
}