package src.main.kotlin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> ans = new ArrayList<>();

        for (int key:map.keySet()){
            if (map.get(key)==1){
                ans.add(key);
            }
        }
        int[] res = new int[ans.size()];
        for (int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    public int[] singleNumber2(int[] nums) {
        long xor = 0;
        for (int i=0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        int bucket1 = 0;
        int bucket2=0;
        long num = xor;
        long n = (xor & (xor-1)) ^ num;
        for (int i = 0 ;i< nums.length;i++){
           if( (nums[i] & n) != 0){
               bucket1^=nums[i];
           }else{
               bucket2^=nums[i];
           }
        }
        int [] ans = new int[]{bucket1,bucket2};
        return ans;
    }
}
