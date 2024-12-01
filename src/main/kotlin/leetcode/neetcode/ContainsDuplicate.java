package src.main.kotlin.leetcode.neetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> st=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(st.contains(nums[i])){
                return true;
            }else{
                st.add(nums[i]);
            }
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
           if (nums[i]==nums[i+1]){
               return true;
           }
        }
        return false;
    }
}
