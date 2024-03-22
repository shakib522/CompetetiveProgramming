package src.main.kotlin.leetcode.q75

import java.util.*

fun main(){
    val scanner= Scanner(System.`in`)
    val n=scanner.nextInt()
    val array=IntArray(n)
    for (i in 0 ..<n){
        array[i]=scanner.nextInt()
    }
    println(src.main.kotlin.leetcode.q75.pivotIndex(array))
}

fun pivotIndex(nums: IntArray): Int {
    val array=IntArray(nums.size+1)
    array[0]=0
    for (i in nums.indices){
        array[i+1]=nums[i]
    }
    for (i in 1 ..< array.size){
        array[i]=array[i-1]+array[i]
    }
    for (i in array){
        println("array: $i")
    }
    for (i in 1 ..< array.size){
        val left=array[i-1]
        val right=array[array.size-1]-array[i]
        if(left==right){
            return i-1
        }
    }
    return -1
}