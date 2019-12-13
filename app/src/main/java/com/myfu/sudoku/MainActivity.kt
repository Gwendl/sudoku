package com.myfu.sudoku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val csv = Grid.fromCsv(getResources().getString(R.string.sudoku1)).exportCsv()
        Log.i("csv", csv)
    }

}
