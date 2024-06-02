package src.main.kotlin.leetcode.top150

import kotlin.math.min

fun jump(nums: IntArray): Int {
    var answer = 0
    val n = nums.size
    var curEnd = 0
    var curFar = 0
    for (i in 0..<n-1){
        curFar= maxOf(curFar,i+nums[i])
        if (i==curEnd){
            answer++
            curEnd=curFar
        }
    }
    return answer
}

var ans = Int.MAX_VALUE
fun helper(nums: IntArray, jump: Int, step: Int): Int {
    if (jump >= nums.size) {
        return step - 1
    }
    if (nums[jump] == nums.last()) {
        ans = min(ans, step)
        return ans
    }
    if (nums[jump] == 0) {
        return step - 1
    }
    for (i in nums.indices) {
        if (nums[i] != 0) {
            helper(nums, nums[i]--, step + 1)
        }
    }
    return ans
}