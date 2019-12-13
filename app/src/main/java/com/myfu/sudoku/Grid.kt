package com.myfu.sudoku

class Grid( private var data: Array<Array<Token>> = Array(6) { Array(5) { Token.BLANK  } }) {

    fun exportCsv(separator: String = ","): String
    {
        val lineToCsv = { line: Array<Token> -> line.joinToString(separator) { it.value.toString() } }
        return data.joinToString(separator, transform = lineToCsv)
    }

    fun clone(): Grid {
        return Grid(data)
    }

    companion object {
        fun initFromCsv(separator: String = ","): Grid
        {
            // implement
            return Grid()
        }
    }
}