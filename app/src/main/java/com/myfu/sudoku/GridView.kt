package com.myfu.sudoku

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.get
import kotlinx.android.synthetic.main.view_grid.view.*

class GridView : LinearLayout{
    private var grid: Grid = Grid()
    private var cellsView: List<List<EditText>>
    @JvmOverloads
    constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_grid, this, true)
        cellsView = getCellsView() as List<List<EditText>>
    }

    private fun getGridView () : ViewGroup =
        grid_sudoku[0] as ViewGroup

    private fun getLinesBlockView() : List<ViewGroup>
            = getGridView().children.filter { view -> view is LinearLayout }.toList() as List<ViewGroup>

    private fun getBlocksView() : List<ViewGroup>
            = getLinesBlockView().map { lineLayout -> lineLayout.children }.flatMap { linesLayout -> linesLayout.toList() }.filter { view -> view is LinearLayout }.toList() as List<ViewGroup>

    private fun getLinesCellsView () : List<ViewGroup> {
        var linesCellsLayout = getBlocksView().map {blockLayout -> blockLayout.children}.flatMap { linesLayout -> linesLayout.toList() }.filter { view -> view is LinearLayout }.toList() as List<LinearLayout>
        var sortedLinesCellsLayout = ArrayList<LinearLayout>()
        for (i in 0 until linesCellsLayout.size)
            sortedLinesCellsLayout.add(linesCellsLayout[i%3*3+i/3+6*(i/9)])
        return sortedLinesCellsLayout
    }

    private fun getCellsView (): List<List<View>>  {
        var cellsEditText = getLinesCellsView () .map { lineCellLayout -> lineCellLayout.children }.flatMap { linesCellsLayout -> linesCellsLayout.toList() }.toList() as List<EditText>
        var rowsEditText: ArrayList<ArrayList<EditText>> = arrayListOf()
        for (i in 0 until 9) {
            var rowEditText: ArrayList<EditText> = arrayListOf()
            for (j in 0 until 9) rowEditText.add(cellsEditText[j + i*9])
            rowsEditText.add(rowEditText)
        }
        return rowsEditText
    }

    private fun disableCell (cellsView: TextView) {
        cellsView.setTextColor(Color.GRAY)
        cellsView.isFocusableInTouchMode = false
    }

    private fun refreshGrid () {
        var lines = grid.getRows()
        for (i in 0..8 step 1)
            for (j in 0..8 step 1) {
                var value = lines[j][i].value
                when (value) {
                    "_" -> cellsView[i][j].setText("")
                    else -> {
                        cellsView[i][j].setText(value)
                        disableCell(cellsView[i][j])
                    }

                }

            }

    }

    fun setGrid (grid: Grid) {
        this.grid = grid
        refreshGrid()
    }
}