package src.main.kotlin.leetcode.top100

import java.util.*
import kotlin.collections.ArrayDeque


fun main(){
    val sc=Scanner(System.`in`)
    val n=sc.nextInt()
    val m=sc.nextInt()
    sc.nextLine()
    val grid= Array(n){CharArray(m)}
    for (i in 0..<n){
        grid[i]=sc.nextLine().toCharArray()
    }
    println(numIslands(grid))
}

fun numIslands(grid: Array<CharArray>): Int {
    var ans=0
    val vis = Array(grid.size) { Array(grid[0].size) { false } }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if(!vis[i][j] && grid[i][j]=='1'){
                ans+=bfs(grid, i,j,vis)
            }
        }
    }
    return ans
}

fun bfs(grid: Array<CharArray>, i: Int,j:Int, vis: Array<Array<Boolean>>) :Int{
    val queue=ArrayDeque<Pair<Int,Int>>()
    queue.add(Pair(i,j))
    vis[i][j]=true
    while (queue.isNotEmpty()){
        val element=queue.removeFirst()
        val f=element.first
        val s=element.second
        if(s<grid[0].size-1 && grid[f][s+1]=='1' && !vis[f][s+1]){
            queue.add(Pair(f,s+1))
            vis[f][s+1]=true
        }
        if(s>0 && grid[f][s-1]=='1' && !vis[f][s-1]){
            queue.add(Pair(f,s-1))
            vis[f][s-1]=true
        }
        if(f<grid.size-1 && grid[f+1][s]=='1' && !vis[f+1][s]){
            queue.add(Pair(f+1,s))
            vis[f+1][s]=true
        }
        if(f>0 && grid[f-1][s]=='1' &&!vis[f-1][s]){
            queue.add(Pair(f-1,s))
            vis[f-1][s]=true
        }
    }
    return 1
}