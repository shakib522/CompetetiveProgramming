package src.main.kotlin.leetcode.top100

import kotlin.math.min


//when a choice affect future answer,use backtracking

fun main() {
    solveNQueens(4).also(::println)
}

fun solveNQueens(n: Int): List<List<String>> {
    val board = mutableListOf<MutableList<Boolean>>()
    for (i in 1..n){
        val res= mutableListOf<Boolean>()
        for (j in 1.. n){
            res.add(false)
        }
        board.add(res)
    }
    val ans = mutableListOf<List<String>>()
    return queens(board, 0, ans)
}

fun queens(
    board: MutableList<MutableList<Boolean>>,
    row: Int,
    ans: MutableList<List<String>>
): MutableList<List<String>> {
    if (row == board.size) {
        ans.add(display(board))
        return ans
    }
    //placing the queen and checking for every row and column
    for (col in 0..<board.size) {
        //place the queen if it is safe
        if (isSafe(board, row, col)) {
            board[row][col] = true
            queens(board, row + 1, ans)
            board[row][col] = false
        }
    }
    return ans
}

fun isSafe(board: MutableList<MutableList<Boolean>>, row: Int, col: Int): Boolean {
    //check vertical row
    for (i in 0..<row) {
        if (board[i][col]) {
            return false
        }
    }
    //diagonal left
    val maxLeft = min(row, col)
    for (i in 1..maxLeft) {
        if (board[row - i][col - i]) {
            return false
        }
    }
    //diagonal right
    val maxRight = min(row, board.size - col - 1)
    for (i in 1..maxRight) {
        if (board[row - i][col + i]) {
            return false
        }
    }
    return true
}

fun display(board: MutableList<MutableList<Boolean>>):List<String> {
    val ans= mutableListOf<String>()
    for (row in board) {
        var res=""
        for (element in row) {
            if (element) {
                res+="Q"
            } else {
                res+="."
            }
        }
        ans.add(res)
    }
    return ans
}