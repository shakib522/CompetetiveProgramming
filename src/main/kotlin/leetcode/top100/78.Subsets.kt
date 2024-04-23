package src.main.kotlin.leetcode.top100

import java.util.*


fun main(){
    val scanner=Scanner(System.`in`)
    val n=scanner.nextInt()
    val ara=IntArray(n)
    for (i in 0 ..<n){
        ara[i]=scanner.nextInt()
    }
    println(subsets(ara))
}

fun subsets(nums: IntArray): List<List<Int>> {
    val ans= mutableListOf<MutableList<Int>>()
    return subsetAns(mutableListOf(),nums.toMutableList(),ans)
}

fun subsetAns(processed:MutableList<Int>,unProcessed:MutableList<Int>,ans:MutableList<MutableList<Int>>):MutableList<MutableList<Int>>{
    if (unProcessed.isEmpty()){
        ans.add(processed)
        return ans
    }
    subsetAns((processed+ unProcessed[0]).toMutableList(), getSubListForSubSet(unProcessed,1,unProcessed.size),ans)
    subsetAns(processed,getSubListForSubSet(unProcessed,1,unProcessed.size),ans)
    return ans
}

fun getSubListForSubSet(list:MutableList<Int>,start:Int,end:Int):MutableList<Int>{
    if (start==list.size){
        return mutableListOf()
    }
    val ans= mutableListOf<Int>()
    for (i in start..<end){
        ans.add(list[i])
    }
    return ans
}