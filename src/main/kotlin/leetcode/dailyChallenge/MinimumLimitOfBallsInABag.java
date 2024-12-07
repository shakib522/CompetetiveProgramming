package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Arrays;

public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        while (low < high) {
            int mid = low + (high - low) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += (int) Math.ceil((n / (double) mid)) - 1;
            }
            if (ops <= maxOperations) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
