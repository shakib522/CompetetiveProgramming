package src.main.kotlin.leetcode.top100.javaSolution;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum=0;
        int ans=0;
        for(Integer num:nums){
            prefixSum+=num;
            ans+=map.getOrDefault(prefixSum-k,0);
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return ans;
    }
}
