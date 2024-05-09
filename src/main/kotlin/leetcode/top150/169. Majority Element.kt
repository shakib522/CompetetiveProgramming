package src.main.kotlin.leetcode.top150

fun majorityElement(nums: IntArray): Int {
    nums.sort()
    val ans=nums.size/2
    var cnt=0
    for (i in 0..<nums.size-1){
        if (nums[i]==nums[i+1]){
            cnt++
        }else{
            cnt=0
        }
        if (cnt>=ans){
            return nums[i]
        }
    }
    return 0
}