package com.myfu.sudoku

import kotlin.math.sqrt

class Grid( private var data: List<List<Token>> = List(SIZE) { List(SIZE) { Token.BLANK  } }) {

    fun exportCsv(separator: String = ","): String
    {
        val lineToCsv = { line: List<Token> -> line.joinToString(separator) { it.value.toString() } }
        return data.joinToString(separator, transform = lineToCsv)
    }

    fun clone(): Grid {
        return Grid(data)
    }

    fun getLines(): List<List<Token>> = data

    fun getRows(): List<List<Token>> {
        val lines = getLines()
        return IntRange(0, SIZE - 1).map { lines.map { line -> line[it] } }
    }

    fun getSquares(): List<List<Token>> {
        // to implement
        return emptyList()
    }

    companion object {
        fun fromCsv(value: String, separator: String = ","): Grid
        {
            val data = value
                .split(separator)
                .map { s -> Token.values().first { it.value == s} }
                .chunked(9)
            return Grid(data)
        }
        const val SIZE = 9
    }
}