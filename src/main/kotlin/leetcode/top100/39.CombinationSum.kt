package src.main.kotlin.leetcode.top100

import java.util.*


fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val numArray=IntArray(n)
    for (i in 0..<n){
        numArray[i]=scanner.nextInt()
    }
    val target=scanner.nextInt()
    println(combinationSum(numArray,target))
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val ans= mutableListOf<MutableList<Int>>()
    return findCombination(mutableListOf(),candidates.toMutableList(),target,ans)
}
fun findCombination(p:MutableList<Int>,up:MutableList<Int>,target:Int,ans:MutableList<MutableList<Int>>):MutableList<MutableList<Int>>{
    if(target==0){
        ans.add(p)
        return ans
    }
    if (target<0){
        return ans
    }

    for (i in 0..< up.size){
        findCombination((p+up[i]).toMutableList(), getSubList(up,i,up.size-1),target-up[i],ans)
    }
    return ans
}

fun getSubList(list:MutableList<Int>,start:Int,end:Int):MutableList<Int>{
    val ans= mutableListOf<Int>()
    for (i in start..end){
        ans.add(list[i])
    }
    return ans
}