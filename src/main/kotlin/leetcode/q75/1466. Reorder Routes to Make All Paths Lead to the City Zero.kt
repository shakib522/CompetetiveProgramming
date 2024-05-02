package src.main.kotlin.leetcode.q75

var count=0
fun minReorder(n: Int, connections: Array<IntArray>): Int {
    val adj= MutableList<MutableList<Pair<Int,Int>>>(n){ mutableListOf() }
    for (con in connections){
        adj[con[0]].add(Pair(con[1],1))
        adj[con[1]].add(Pair(con[0],0))
    }
    println("adj list: $adj")
    dfs(adj,0,-1)
    return count
}

fun dfs(adj:MutableList<MutableList<Pair<Int,Int>>> , node: Int, parent:Int) {
    for (v in adj[node]){
        if (v.first!=parent){
            count+=v.second
            dfs(adj,v.first,node)
        }
    }
}
