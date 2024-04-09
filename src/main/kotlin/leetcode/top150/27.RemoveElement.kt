package src.main.kotlin.leetcode.top150

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

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var ans:ListNode? = ListNode(0)
        while(list1!=null && list2!=null){
            if(list1.`val`<=list2.`val`){
                ans.next=ListNode(list1.`val`)
                list1=list1.next
            }else{
                ans.next = ListNode(list2.`val`)
                list2=list2.next
            }
        }
        while(list1!=null){
            ans.next=ListNode(list1.`val`)
        }
        while(list2!=null){
            ans.next=ListNode(list2.`val`)
        }
        ans=ans.next
        return ans
    }
}