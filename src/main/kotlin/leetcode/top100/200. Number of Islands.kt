package src.main.kotlin.leetcode.top100

import java.util.Scanner
import kotlin.math.max


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
    val vis = Array(max(grid.size, grid[0].size)) { false }
    for (i in grid.indices) {
        if(!vis[i]) {
            val res=dfs(grid, i, vis)
            println(res)
            if(res){
                ans++
            }
        }
    }
    return ans
}

fun dfs(grid: Array<CharArray>, node: Int, vis: Array<Boolean>) :Boolean{
    vis[node] = true
    var bool=false
    for (i in grid[node].indices) {
        if(grid[node][i]=='1'){
            bool=true
        }
        if (grid.size>i&&grid[node][i] == '1' && !vis[i]) {
            bool=true
            dfs(grid, i, vis)
        }
    }
    return bool
}