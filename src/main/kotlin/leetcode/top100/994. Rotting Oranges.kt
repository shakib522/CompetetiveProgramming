package src.main.kotlin.leetcode.top100

import kotlin.math.max


fun orangesRotting(grid: Array<IntArray>): Int {
    return orangesRottingBfs(grid)
}

fun orangesRottingBfs(grid: Array<IntArray>): Int {
    val vis = Array(grid.size) { Array(grid[0].size) { false } }
    val q = ArrayDeque<Pair<Pair<Int, Int>, Int>>()
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 2) {
                q.addFirst(Pair(Pair(i, j), 0))
                vis[i][j] = true
            }
        }
    }
    var ans = 0

    while (q.isNotEmpty()) {
        val node = q.removeFirst()
        val i = node.first.first
        val j = node.first.second
        val time = node.second
        ans= max(ans,time)
        if (j < grid[0].size - 1 && grid[i][j + 1] == 1 && !vis[i][j + 1]) {
            grid[i][j + 1] = 2
            q.addLast(Pair(Pair(i, j + 1), time + 1))
        }
        if (j > 0 && grid[i][j - 1] == 1 && !vis[i][j - 1]) {
            grid[i][j - 1] = 2
            q.addLast(Pair(Pair(i, j - 1), time + 1))
        }
        if (i < grid.size - 1 && grid[i + 1][j] == 1 && !vis[i + 1][j]) {
            grid[i + 1][j] = 2
            q.addLast(Pair(Pair(i + 1, j), time + 1))
        }
        if (i > 0 && grid[i - 1][j] == 1 && !vis[i - 1][j]) {
            grid[i - 1][j] = 2
            q.addLast(Pair(Pair(i-1, j), time + 1))
        }
    }

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                return -1
            }
        }
    }
    return ans
}