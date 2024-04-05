package src.main.kotlin.leetcode.top150

import java.util.*


fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val num=IntArray(n)
    for (i in 0..<n){
        num[i]=scanner.nextInt()
    }
    threeSum(num).forEach {
        it.forEach {e->
            print("$e ")
        }
    }
}
fun threeSum(nums: IntArray): List<List<Int>> {
    val size=nums.size
    val ans=mutableListOf<List<Int>>()
    for(i in 0..<size){
        for(j in (i+1)..<size){
            for(k in (j+1)..<size){
                if(nums[i]+nums[j]+nums[k]==0){
                    var add=listOf(nums[i],nums[j],nums[k])
                    add=add.sorted()
                    if(!ans.contains(add)){
                        ans.add(add)
                    }
                }
            }
        }
    }
    return ans.toList()
}