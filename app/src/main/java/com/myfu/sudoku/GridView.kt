package com.myfu.sudoku

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.core.view.get
import kotlinx.android.synthetic.main.view_grid.view.*

class GridView : LinearLayout{
    private var grid: Grid = Grid()
    private var cellsView: List<EditText>
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_grid, this, true)
        cellsView = getCellsView()
    }

    private fun getCellsView (): List<EditText>  {
        var gridSudokyLayout = grid_sudoku[0] as LinearLayout
        var linesLayout = gridSudokyLayout.children.filter { view -> view is LinearLayout }.toList() as List<LinearLayout>
        var blocksLayout = linesLayout.map { lineLayout -> lineLayout.children }.flatMap { linesLayout -> linesLayout.toList() }.filter { view -> view is LinearLayout }.toList() as List<LinearLayout>
        var linesCellsLayout = blocksLayout.map {blockLayout -> blockLayout.children}.flatMap { linesLayout -> linesLayout.toList() }.filter { view -> view is LinearLayout }.toList() as List<LinearLayout>
        return linesCellsLayout.map { lineCellLayout -> lineCellLayout.children }.flatMap { linesCellsLayout -> linesCellsLayout.toList() }.toList() as List<EditText>
    }

    private fun refreshGrid () {
        var lines = grid.getLines()
        for (i in 0..8 step 1) {
            cellsView[0+i*3+i/3*18].setText(lines[0][i].value)
            cellsView[1+i*3+i/3*18].setText(lines[1][i].value)
            cellsView[2+i*3+i/3*18].setText(lines[2][i].value)
            cellsView[9+i*3+i/3*18].setText(lines[3][i].value)
            cellsView[10+i*3+i/3*18].setText(lines[4][i].value)
            cellsView[11+i*3+i/3*18].setText(lines[5][i].value)
            cellsView[18+i*3+i/3*18].setText(lines[6][i].value)
            cellsView[19+i*3+i/3*18].setText(lines[7][i].value)
            cellsView[20+i*3+i/3*18].setText(lines[8][i].value)
        }
    }

    fun setGrid (grid: Grid) {
        this.grid = grid
        refreshGrid()
    }
}