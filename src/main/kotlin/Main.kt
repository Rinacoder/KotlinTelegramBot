package org.example

import java.io.File

fun main() {

    val wordsFile:File = File("words.txt")
    val wordsLines = wordsFile.readLines()
    for(i in wordsLines){
        println(i)
    }

}