package com.myfu.sudoku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        load_button.setOnClickListener{grid_sudoku.setGrid(Grid.fromCsv(getResources().getString(R.string.sudoku1)))}
        val csv = Grid.fromCsv(getResources().getString(R.string.sudoku1)).getSquares()
    }

}
