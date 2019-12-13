package com.myfu.sudoku

class Grid( private var data: Array<Array<Token>> = Array(9) { Array(9) { Token.BLANK  } }) {

    fun exportCsv(separator: String = ","): String
    {
        val lineToCsv = { line: Array<Token> -> line.joinToString(separator) { it.value.toString() } }
        return data.joinToString(separator, transform = lineToCsv)
    }

    fun clone(): Grid {
        return Grid(data)
    }

    companion object {
        fun fromCsv(value: String, separator: String = ","): Grid
        {
            val data = value
                .split(separator)
                .map { s -> Token.values().first { it.value == s} }
                .chunked(9) { it.toTypedArray() }
                .toTypedArray()
            return Grid(data)
        }
    }
}