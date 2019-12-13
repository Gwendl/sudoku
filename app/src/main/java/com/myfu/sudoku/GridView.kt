package com.myfu.sudoku

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.view.children
import kotlinx.android.synthetic.main.view_box.view.*
import kotlinx.android.synthetic.main.view_grid.view.*

class GridView : LinearLayout{
    private var grid: Grid = Grid()

    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_grid, this, true)
    }

    fun setGrid (grid: Grid) {
        this.grid = grid

        grid_sudoku.children.iterator().forEach {

        }
        var t = block1.cell1 as EditText
        t.setText("1")
    }
}