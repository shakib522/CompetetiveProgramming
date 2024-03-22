package src.main.kotlin.leetcode.q75

fun main(){

}

fun search(nums: IntArray, target: Int): Int {
    return binarySearch(0,nums.size-1,nums,target)
}
fun binarySearch(start:Int,end:Int,nums:IntArray,target:Int):Int{
    if(start>end){
        return -1
    }

    val mid=start+(end-start)/2
    if (nums[mid]==target){
        return mid
    }
    if (nums[mid]>target){
        return binarySearch(start,mid-1,nums,target)
    }
    return binarySearch(mid+1,end,nums,target)
}