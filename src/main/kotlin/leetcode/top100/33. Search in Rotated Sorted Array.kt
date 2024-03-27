package src.main.kotlin.leetcode.top100

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        return bSearch(nums,0,nums.size-1,target)
    }

    fun bSearch(nums:IntArray,s:Int,e:Int,target:Int):Int{
        if(s>e){
            return -1
        }
        val mid=s+(e-s)/2
        if(nums[mid]==target){
            return mid
        }
        if(nums[s]<=nums[mid]){
            if(target>=nums[s] && target<=nums[mid]){
                return bSearch(nums,s,mid-1,target)
            }else{
                return bSearch(nums,mid+1,e,target)
            }
        }
        if(target>=nums[mid]&&target<=nums[e]){
            return bSearch(nums,mid+1,e,target)
        }
        return bSearch(nums,s,mid-1,target)
    }
}