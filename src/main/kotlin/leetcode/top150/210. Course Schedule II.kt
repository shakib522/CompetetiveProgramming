package src.main.kotlin.leetcode.top150

import java.util.*
import kotlin.collections.HashMap

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val adj = Array<MutableList<Int>>(numCourses) { mutableListOf() }
    for (it in prerequisites) {
        adj[it[1]].add(it[0])
    }
    return topologicalSort(numCourses,adj)
}

fun topologicalSort(v: Int, adj: Array<MutableList<Int>>): IntArray {
    val stack = Stack<Int>()
    val vis = Array(v) { false }
    for (i in 0..<v) {
        if (!vis[i]) {
            topologicalDfs(i,adj,stack,vis)
        }
    }
    return checkForCycle(stack,adj,v)
}

fun topologicalDfs(
    node: Int,
    adj: Array<MutableList<Int>>,
    stack: Stack<Int>,
    vis:Array<Boolean>
) {
    vis[node]=true
    for (it in adj[node]){
        if(!vis[it]){
            topologicalDfs(it,adj,stack,vis)
        }
    }
    stack.push(node)
}


fun checkForCycle(st: Stack<Int>, adj: Array<MutableList<Int>>, v: Int):IntArray{
    val map:MutableMap<Int,Int> = HashMap()
    var indx=0
    val ans= mutableListOf<Int>()
    while (st.isNotEmpty()){
        ans.add(st.peek())
        map[st.pop()]=indx++
    }
    for (i in 0..<v){
        for (it in adj[i]){
            if (map[i]!! >= map[it]!!){
                return intArrayOf()
            }
        }
    }
    return ans.toIntArray()
}

