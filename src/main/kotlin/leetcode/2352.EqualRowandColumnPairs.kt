package leetcode

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val row = scanner.nextInt()
    val col = scanner.nextInt()
    val grid = Array(row) { IntArray(col) }
    for (i in 0..<row) {
        for (j in 0..<col) {
            grid[i][j] = scanner.nextInt()
        }
    }
    println(equalPairs(grid))
}

fun equalPairs(grid: Array<IntArray>): Int {
    var ans = 0
    val row= mutableListOf<MutableList<Int>>()
    val col= mutableListOf<MutableList<Int>>()
    for (i in grid.indices){
        row.add(grid[i].toMutableList())
    }
    for (i in grid.indices){
        val list= mutableListOf<Int>()
        for (j in grid[i].indices){
           list.add(grid[j][i])
        }
        col.add(list)
    }
    for (i in row.indices){
        for (j in col.indices){
            if (row[i]==col[j]){
                ans++
            }
        }
    }
    return ans
}