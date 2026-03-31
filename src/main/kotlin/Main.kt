package org.example

import java.io.File
import java.io.IOException

const val FILE_NAME = "words.txt"

fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))
    val wordsFile: File = File(FILE_NAME)
    try {
        val wordsLines = wordsFile.readLines()
        for (line in wordsLines) {
            println(line)
        }
    } catch (e: IOException) {
        println("Ошибка при работе с файлом: ${e.message}")
    }

}
