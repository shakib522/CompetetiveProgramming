package src.main.kotlin.leetcode.top100

import kotlin.math.max


fun searchInsert(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] == target) {
            return mid
        }
        if (nums[mid] > target) {
            end = mid - 1
        } else if (nums[mid] < target) {
            start = mid + 1
        }
        if (start == end) {
            if (nums[start] < target) {
                return start + 1
            } else {
                return max(0, start)
            }
        }
    }
    return start
}