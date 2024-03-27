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

//iterative approach
fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right){
        val mid = left + (right - left)/2
        if (nums[mid] == target){
            return mid
        }



        if (nums[left] <= nums[mid]){
            if (nums[left] <= target && target <= nums[mid]){
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            if (nums[mid] <= target && target <= nums[right]){
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }

    return -1
}