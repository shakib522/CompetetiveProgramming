package src.main.kotlin.leetcode

import java.util.*


fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val numArray=IntArray(n)
    for (i in 0..<n){
        numArray[i]=scanner.nextInt()
    }
    println(removeDuplicates(numArray))
}


fun removeDuplicates(nums: IntArray): Int {
    if (nums.size==1){
        return 1
    }
    var p1=0
    var p2=1
    while (p2<nums.size){
        if (nums[p1]!=nums[p2]){
            p2++
        }else{
            p1++
            nums[p1]=nums[p2]
            p2++
        }
    }
    return p1+1
}