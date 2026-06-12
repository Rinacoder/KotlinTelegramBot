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

    try {
        val dictionary = loadDictionary()

        while (true) {
            println(
                """
                1 - Учить слова
                2 - Статистика
                0 - Выход
                """.trimIndent()
            )
            val menu = readln()
            when (menu) {
                "1" -> println("Учить слова")
                "2" -> println("Статистика")
                "0" -> break
                else -> println("Такого пункта меню не существует. Введите 1, 2 или 0")
            }
        }

    } catch (e: IOException) {
        println("Ошибка при работе с файлом: ${e.message}")
    }

}

fun loadDictionary(): MutableList<Word> {
    val wordsFile: File = File(FILE_NAME)
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
    return dictionary
}
