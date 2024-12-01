package src.main.kotlin.leetcode.neetcode;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i])+1);
            }else{
                mp.put(nums[i],1);
            }
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(mp.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        int [] ar=new int[k];
        for (int i = 0; i < k; i++) {
            ar[i]=list.get(i).getKey();
        }
        return ar;
    }
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        int[] ar = new int[k];
        for (int key : mp.keySet()) {
            int frequency=mp.get(key);
            if (bucket[frequency]==null){
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int counter=0;
        for (int i = bucket.length-1; i >=0 && counter<k; i--) {
            if (bucket[i]!=null){
                for(Integer in:bucket[i]){
                    ar[counter++]=in;
                }
            }
        }
        return ar;
    }
}
