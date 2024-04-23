package src.main.kotlin.leetcode.top100

import kotlin.math.abs


fun main() {

}

fun singleNumber(nums: IntArray): Int {
    if (nums.size==1){
        return nums.last()
    }
    nums.sort()
    var i=0
    val siz=nums.size
    var loop=siz
    if (siz%2==1){
        loop--
    }
    while (i<loop){
        if (abs( nums[i]-nums[i+1])==0){
            i+=2
        }else{
            return nums[i]
        }
    }
    if (siz%2==1&& nums[siz-1]!=nums[siz-2]){
        return nums[siz-1]
    }
    return 0
}