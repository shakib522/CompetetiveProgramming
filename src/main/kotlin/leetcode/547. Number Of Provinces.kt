package src.main.kotlin.leetcode


fun findCircleNum(isConnected: Array<IntArray>): Int {
    val vis = Array(isConnected.size) { false }
    var ans=0
    for (i in isConnected.indices) {
        if(!vis[i]) {
            ans++
            dfsInAdjacencyMatrix(vis,i,isConnected)
        }
    }
    return ans
}

fun dfsInAdjacencyMatrix(
    vis: Array<Boolean>,
    node: Int,
    isConnected: Array<IntArray>
){
    vis[node] = true
    for (j in isConnected[node].indices) {
        if (isConnected[node][j] == 1 && !vis[j]) {
            dfsInAdjacencyMatrix(vis, j, isConnected)
        }
    }
}