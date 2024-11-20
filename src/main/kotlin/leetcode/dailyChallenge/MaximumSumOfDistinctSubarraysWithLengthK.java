package src.main.kotlin.leetcode.dailyChallenge;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    static public void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1,1,1,7,8,9},3));
    }
    public static long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        long ans=0;
        int len=nums.length;
        Set<Integer> st=new HashSet<>();
        int end;
        int begin=0;
        for ( end = 0; end < len; end++) {
            if (!st.contains(nums[end])){
                sum+=nums[end];
                st.add(nums[end]);
                if (end-begin+1==k){
                    ans=Math.max(ans,sum);
                    sum-=nums[begin];
                    st.remove(nums[begin]);
                    begin++;
                }
            }else{
                while (nums[begin]!=nums[end]){
                    st.remove(nums[begin]);
                    sum-=nums[begin];
                    begin++;
                }
                begin++;
            }
        }
        return ans;
    }
}
