package src.main.kotlin.leetcode.contest


fun numberOfRightTriangles(grid: Array<IntArray>): Long {
    var ans=0L
    val row=IntArray(grid.size)
    val col=IntArray(grid[0].size)

    for (i in grid.indices){
        var rowCount=0
        for (j in grid[i].indices){
            if (grid[i][j]==1){
                rowCount++
            }
        }
        row[i]=rowCount
    }

    for (i in grid[0].indices){
        var colCount=0
        for (j in grid.indices){
            if(grid[j][i]==1){
                colCount++
            }
        }
        col[i]=colCount
    }

    for (i in grid.indices){
        for (j in grid[i].indices){
            if (grid[i][j]==1){
                ans+=(row[i]-1)*(col[j]-1)
            }
        }
    }
    return ans
}