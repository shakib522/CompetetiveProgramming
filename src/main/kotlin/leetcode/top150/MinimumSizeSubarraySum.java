package src.main.kotlin.leetcode.top150;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int right;
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }
        return minLength;
    }
}
