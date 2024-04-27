package src.main.kotlin.leetcode.contest

import kotlin.math.max


fun numberOfRightTriangles(grid: Array<IntArray>): Long {
    var ans=0L
    for (i in grid.indices){
        for (j in grid[i].indices){
            if (grid[i][j]==1){
                ans+=countOne(i,j,grid)
            }
        }
    }
    return ans
}

fun countOne(i:Int,j:Int,grid: Array<IntArray>):Long{
    var right=-1L
    var down=-1L
    var up=-1L
    var left=-1L
    for (col in j..<grid[i].size){
        if (grid[i][col]==1){
            right++
        }
    }
    for (row in i..<grid.size){
        if (grid[row][j]==1){
            down++
        }
    }

    for (row in i downTo 0){
        if (grid[row][j]==1){
            up++
        }
    }
    for (col in j downTo 0){
        if (grid[i][col]==1){
            left++
        }
    }

    val ans= max(0,right*down)+ max(0,right*up)
    val ans2= max(0,left*down)+ max(0,left*up)

    return ans+ans2
}