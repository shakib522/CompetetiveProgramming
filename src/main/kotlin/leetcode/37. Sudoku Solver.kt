package src.main.kotlin.leetcode

import kotlin.math.sqrt

fun display(board: Array<CharArray>) {
    for (row in board) {
        for (col in row) {
            print("$col ")
        }
        println()
    }
}

fun main() {
   val a=Array(2){0}
}

fun solveSudoku(board: Array<CharArray>): Unit {
    solve(board)
}

fun solve(board: Array<CharArray>): Boolean {
    val n = board.size
    var row = -1
    var col = -1
    var emptyLeft = true
    //this is how we are replacing the r,c from arguments
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (board[i][j] == '.') {
                row = i
                col = j
                emptyLeft = false
                break
            }
        }
        if (!emptyLeft) {
            break
        }
    }
    if (emptyLeft) {
        return true
        //sudoku is solved
    }
    //backtrack
    for (i in 1..9) {
        if (isSafe(board, row, col, i)) {
            board[row][col] = i.digitToChar()
            if (solve(board)) {
                //found the answer
                return true
            } else {
                //backtrack
                board[row][col] ='.'
            }
        }
    }
    return false
}



fun isSafe(board: Array<CharArray>, row: Int, col: Int, num: Int): Boolean {
    //check the row

    for (i in board.indices) {
        //check if the number is in the row
        if (board[row][i].digitToIntOrNull() == num) {
            return false
        }
    }

    //check for the column
    for (nums in board) {
        //check if the number is in the col
        if (nums[col].digitToIntOrNull() == num) {
            return false
        }
    }

    val sqrt = sqrt(board.size.toDouble()).toInt()
    val rowStart = row - row % sqrt
    val colStart = col - col % sqrt
    for (r in rowStart..< (rowStart+sqrt)){
        for (c in colStart..<colStart+sqrt){
            if (board[r][c].digitToIntOrNull() == num) {
                return false
            }
        }
    }
    return true
}