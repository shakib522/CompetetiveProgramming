package src.main.kotlin.leetcode.top150;

import java.util.Arrays;

public class SingleNumber2 {
    public static void main(String[] args) {
        System.out.println(((1^2) ));
    }
    public int singleNumber(int[] nums) {
        long ans=0;
        for (int bitIndex=0;bitIndex<32;bitIndex++){
            int cnt=0;
            for (int i=0;i<nums.length;i++){
                if ((nums[i] & (1<<bitIndex))>=1){
                    cnt++;
                }
            }
            if (cnt%3==1){
                ans = ans | (1<<bitIndex);
            }
        }
        return (int) ans;
    }
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i=1;i<nums.length;i+=3){
            if (nums[i]!=nums[i-1]){
                return nums[i-1];
            }
        }
        return nums[len-1];
    }
    public int singleNumber3(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
