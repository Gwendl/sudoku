package com.myfu.sudoku

class Grid {
    private var data = Array(6) { Array(5) { Token.BLANK  } }

    fun initFromCsv(separator: String = ","): Grid
    {
        // implement
        return this
    }

    fun exportCsv(separator: String = ","): String
    {
        val lineToCsv = { line: Array<Token> -> line.joinToString(separator) { it.value.toString() } }
        return data.joinToString(separator, transform = lineToCsv)
    }
}