package src.main.kotlin.leetcode.top150

fun canJump(nums: IntArray): Boolean {
    var goal=nums.size-1
    for(i in nums.size-2 downTo 0){
        if((nums[i]+i)>=goal){
            goal=i
        }
    }
    return goal==0
}