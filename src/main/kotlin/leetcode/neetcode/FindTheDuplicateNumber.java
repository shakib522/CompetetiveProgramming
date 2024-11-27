package src.main.kotlin.leetcode.neetcode;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int num:nums){
            int index=Math.abs(num);
            if (nums[index]<0){
                return index;
            }
            nums[index]=-nums[index];
        }
        return 0;
    }
}