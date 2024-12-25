package src.main.kotlin.leetcode;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int suffix=1;
        int prefix=1;
        int ans=Integer.MIN_VALUE;
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            suffix*=nums[len-1-i];
            prefix*=nums[i];
            ans=Math.max(ans,Math.max(prefix,suffix));
            if (suffix==0) suffix=1;
            if (prefix==0) prefix=1;
        }
        return ans;
    }
}
