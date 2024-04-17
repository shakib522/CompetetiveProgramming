package src.main.kotlin.leetcode

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val array = IntArray(n)
    for (i in 0..<n) {
        array[i] = scanner.nextInt()
    }
    println(permute(array))
}

fun permute(nums: IntArray): List<List<Int>> {
    val ans= mutableListOf<MutableList<Int>>()
    helper(mutableListOf(),nums.toMutableList(), ans)
    return ans
}

fun helper(processed:MutableList<Int>,unProcessed:MutableList<Int>,ans:MutableList<MutableList<Int>>):MutableList<MutableList<Int>>{
    if (unProcessed.isEmpty()){
        ans.add(processed)
        return ans
    }
    val toBeAdd=unProcessed[0]
    for (i in 0..processed.size){
        val s= getSubList(processed,0,i)
        val e= getSubList(processed,i,processed.size)
        helper((s+toBeAdd+e).toMutableList(), getSubList(unProcessed,1,unProcessed.size),ans)
    }
    return ans
}

fun getSubList(array:MutableList<Int>,start:Int,end:Int):MutableList<Int>{
    val ans= mutableListOf<Int>()
    for (i in start..<end){
        ans.add(array[i])
    }
    return ans
}