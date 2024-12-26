package src.main.kotlin.leetcode.dailyChallenge;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,0,0,target);
    }
    int helper(int[] nums,int sum,int index,int target){
        if (index>= nums.length) return sum==target?1:0;
        int subtract=helper(nums, sum-nums[index], index+1, target);
        int add=helper(nums, sum+nums[index], index+1, target);
        return subtract+add;
    }
}
