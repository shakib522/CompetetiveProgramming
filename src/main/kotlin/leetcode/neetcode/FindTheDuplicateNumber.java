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
    public int findDuplicate2(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}