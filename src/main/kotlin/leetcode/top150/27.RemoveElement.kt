package src.main.kotlin.leetcode.top150

import src.main.kotlin.leetcode.top100.ListNode

fun removeElement(nums: IntArray, `val`: Int): Int {
    var l=0
    var r=nums.size-1
    while(l<=r){
        if(nums[l]==`val`&&nums[r]!=`val`){
            val temp=nums[l]
            nums[l]=nums[r]
            nums[r]=temp
        }
        if (nums[l]!=`val`){
            l++
        }
        if(nums[r]==`val`){
            r--
        }

    }
    var ans=0
    for (i in nums.indices){
        if(nums[i]!=`val`){
            ans++
        }else{
            break
        }
    }
    return ans
}