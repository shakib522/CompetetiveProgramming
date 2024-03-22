package src.main.kotlin.leetcode.q75

import java.util.Scanner

fun main(){
    val scanner=Scanner(System.`in`)
    val n=scanner.nextInt()
    val array=IntArray(n)
    for (i in 0..<n){
        array[i]=scanner.nextInt()
    }
    val target=scanner.nextInt()
    searchRange(array,target).forEach {
        println(it)
    }
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    val upperBound= bSearchUpper(nums,target,0,nums.size-1,-1)
    val lowerBound= bSearchLower(nums,target,0,nums.size-1,-1)
    val ar=IntArray(2)
    ar[0]=lowerBound
    ar[1]=upperBound
    return ar
}

fun bSearchUpper(nums:IntArray,target:Int,left:Int,right:Int,index:Int):Int{
    if (left>right){
        return index
    }
    val mid=left+(right-left)/2
    if (nums[mid]==target){
        return bSearchUpper(nums,target,mid+1,right,mid)
    }
    if (nums[mid]<target){
        return bSearchUpper(nums,target,mid+1,right,index)
    }else if(nums[mid]>target){
        return bSearchUpper(nums,target,left,mid-1,index)
    }
    return index
}

fun bSearchLower(nums:IntArray,target:Int,left:Int,right:Int,index:Int):Int{
    if (left>right){
        return index
    }
    val mid=left+(right-left)/2
    if (nums[mid]==target){
        return bSearchLower(nums,target,left,mid-1,mid)
    }
    if (nums[mid]<target){
        return bSearchLower(nums,target,mid+1,right,index)
    }else if(nums[mid]>target){
        return bSearchLower(nums,target,left,mid-1,index)
    }
    return index
}