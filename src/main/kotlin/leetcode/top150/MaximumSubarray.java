package src.main.kotlin.leetcode.top150;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int result=nums[0];
        int maxSubarray=nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSubarray=Math.max(maxSubarray+nums[i],nums[i]);
            result=Math.max(result,maxSubarray);
        }
        return result;
    }
}
