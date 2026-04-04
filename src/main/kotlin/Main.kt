package org.example

import java.io.File
import java.io.IOException

const val FILE_NAME = "words.txt"

data class Word(
    val original: String,
    val translate: String,
    val correctAnswersCount: Int = 0
)

fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))
    val wordsFile: File = File(FILE_NAME)
    try {
        val wordsLines = wordsFile.readLines()
        val dictionary = mutableListOf<Word>()
        for (line in wordsLines) {
            val wordData = line.split("|")
            if (wordData.size < 2)
                continue

            dictionary.add(
                Word(
                    original = wordData[0],
                    translate = wordData[1],
                    correctAnswersCount = wordData.getOrNull(2)?.toIntOrNull() ?: 0
                )
            )
        }
        println(dictionary)
    } catch (e: IOException) {
        println("Ошибка при работе с файлом: ${e.message}")
    }

}
