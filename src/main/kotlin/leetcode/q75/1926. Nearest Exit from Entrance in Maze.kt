package src.main.kotlin.leetcode.q75

import kotlin.math.min


fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
    val vis = Array(maze.size) { Array(maze[0].size) { false } }
    val q = ArrayDeque<Pair<Int, Pair<Int, Int>>>()
    var ans = 0
    var result = Int.MAX_VALUE

    q.addLast(Pair(ans, Pair(entrance[0], entrance[1])))
    vis[entrance[0]][entrance[1]] = true
    var flag = true
    while (q.isNotEmpty()) {
        val i = q.first().second.first
        val j = q.first().second.second
        ans = q.first().first
        q.removeFirst()
        if (j < maze[0].size - 1 && maze[i][j + 1] == '.' && !vis[i][j + 1]) {
            vis[i][j + 1] = true
            q.addLast(Pair(ans + 1, Pair(i, j + 1)))
        }
        if (j > 0 && maze[i][j - 1] == '.' && !vis[i][j - 1]) {
            vis[i][j - 1] = true
            q.addLast(Pair(ans + 1, Pair(i, j - 1)))
        }
        if (i < maze.size - 1 && maze[i + 1][j] == '.' && !vis[i + 1][j]) {
            vis[i + 1][j] = true
            q.addLast(Pair(ans + 1, Pair(i + 1, j)))
        }
        if (i > 0 && maze[i - 1][j] == '.' && !vis[i - 1][j]) {
            vis[i - 1][j] = true
            q.addLast(Pair(ans + 1, Pair(i - 1, j)))
        }
        if ((i == 0 || j == 0 || i == maze.size - 1 || j == maze[0].size - 1) && (i != entrance[0] || j != entrance[1])) {
            result = min(result, ans)
            flag = false
        }
    }
    if (flag) {
        return -1
    }
    return result
}
