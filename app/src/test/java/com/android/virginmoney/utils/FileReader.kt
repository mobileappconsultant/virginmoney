package com.android.virginmoney.utils

import java.io.InputStreamReader

object FileReader {
    fun readStringFromFile(fileName: String): String {
        return InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(fileName)).use { it.readText() }
    }
}
