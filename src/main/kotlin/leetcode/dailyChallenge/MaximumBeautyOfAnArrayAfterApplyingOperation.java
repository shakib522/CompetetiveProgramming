package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {
    public static void main(String[] args) {
        MaximumBeautyOfAnArrayAfterApplyingOperation m=new MaximumBeautyOfAnArrayAfterApplyingOperation();
        System.out.println(m.maximumBeauty(new int[]{1,1,1,1},10));
    }
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        int left=0;
        int right=1;
        while (right<nums.length){
            if ((nums[right]-nums[left])<=k*2){
                right++;
            }else{
                ans=Math.max(ans,right-left);
                left++;
                if (left>right){
                    right++;
                }
            }
        }
        ans=Math.max(ans,right-left);
        return ans;
    }
}
