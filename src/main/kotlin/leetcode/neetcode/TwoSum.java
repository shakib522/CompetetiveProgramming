package src.main.kotlin.leetcode.neetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            if (mp.containsKey(target-nums[j]) && mp.get(target-nums[j])!=j) {
                return new int[]{j, mp.get(target-nums[j])};
            }
        }
        return null;
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(target-nums[i])) {
                return new int[]{i, mp.get(target-nums[i])};
            }
            mp.put(nums[i], i);
        }
        return null;
    }
}
