package src.main.kotlin.leetcode.top150

fun solve(board: Array<CharArray>): Unit {
    val vis = Array(board.size) { Array(board[0].size) { false } }
    for (i in board.indices){
        for (j in board[i].indices){
            if (board[i][j]=='O' && (i==0 || i==board.size-1 || j==0 || j==board[i].size-1) && !vis[i][j]){
                surroundedBfs(board,i,j,vis)
            }
        }
    }

    for (i in board.indices){
        for (j in board[i].indices){
            if (board[i][j]=='O' && !vis[i][j]){
                board[i][j]='X'
            }
        }
    }

}

fun surroundedBfs(grid: Array<CharArray>,i:Int,j:Int, vis: Array<Array<Boolean>>) {
    val queue=ArrayDeque<Pair<Int,Int>>()
    queue.addFirst(Pair(i,j))
    vis[i][j]=true
    while (queue.isNotEmpty()) {
        val f=queue.first().first
        val s=queue.first().second
        queue.removeFirst()
        if (s < grid[0].size - 1 && grid[f][s + 1] == 'O' && !vis[f][s + 1]) {
            queue.add(Pair(f, s + 1))
            vis[f][s + 1] = true
        }
        if (s > 0 && grid[f][s - 1] == 'O' && !vis[f][s - 1]) {
            queue.add(Pair(f, s - 1))
            vis[f][s - 1] = true
        }
        if (f < grid.size - 1 && grid[f + 1][s] == 'O' && !vis[f + 1][s]) {
            queue.add(Pair(f + 1, s))
            vis[f + 1][s] = true
        }
        if (f > 0 && grid[f - 1][s] == 'O' && !vis[f - 1][s]) {
            queue.add(Pair(f - 1, s))
            vis[f - 1][s] = true
        }
    }
}
